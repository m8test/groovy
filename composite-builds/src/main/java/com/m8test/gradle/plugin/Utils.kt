package com.m8test.gradle.plugin

import org.gradle.api.Project
import java.io.File
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Author: HyLee
 * Date: 2024/5/10 12:21
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: 一些工具方法
 */
object Utils {
    private var currentIndex = 0x0100
    private val usedDict = mutableSetOf<Char>()
    fun Project.commonProguardFile(): File {
        return File(rootProject.projectDir, "proguard-rules.pro")
    }

    private fun generateProguardDictionary(): MutableSet<String> {
        println("current index=$currentIndex")
        val size = Random.nextInt(IntRange(32, 64))
        val set = mutableSetOf<String>()
        while (set.size < size) {
            val it = currentIndex
            if (Character.isValidCodePoint(it) && Character.isJavaIdentifierPart(it)) {
                val element = String(Character.toChars(it))[0]
                if (Character.isJavaIdentifierStart(element)) {
                    if (!usedDict.contains(element)) {
                        set.add(element.toString())
                        usedDict.add(element)
                    } else {
                        System.err.println("element was used:$element,element size:${usedDict.size}")
                    }
                }
            }
            currentIndex++
        }
        return set
    }

    private const val DICT_GENERATED_NAME = "build/tmp/dict-generated.txt"
    private const val PROGUARD_GENERATED_NAME = "build/tmp/proguard-generated.txt"
    private const val CLASS_PROGUARD_GENERATED_NAME = "build/tmp/class-dict-generated.txt"
    private const val PACKAGE_PROGUARD_GENERATED_NAME = "build/tmp/package-dict-generated.txt"

    fun Project.getProguardGeneratedFile(): File {
        return getRelativePath(PROGUARD_GENERATED_NAME)
    }

    private fun Project.getRelativePath(relativePath: String): File {
        return File(getProjectDirectory(), relativePath)
    }

    private fun Project.getProjectDirectory(): File {
        return projectDir
    }

    private fun deleteAndCreateNewFile(file: File) {
        file.mkdirs()
        file.delete()
        file.createNewFile()
    }

    private const val GENERATED_PROGUARD_FILE_TASK_NAME = "generateProguardFile"
    fun Project.registerGenerateProguardDictionaryTask() {
        tasks.register(GENERATED_PROGUARD_FILE_TASK_NAME) {
            doLast {
                val proguardGeneratedFile = getProguardGeneratedFile()
                deleteAndCreateNewFile(proguardGeneratedFile)
                proguardGeneratedFile.writeText(
                    """
                        -basedirectory ${getProjectDirectory().canonicalPath}
                        -obfuscationdictionary $DICT_GENERATED_NAME 
                        -classobfuscationdictionary $CLASS_PROGUARD_GENERATED_NAME
                        -packageobfuscationdictionary $PACKAGE_PROGUARD_GENERATED_NAME
                    """.trimIndent()
                )
                writeProguardDict(DICT_GENERATED_NAME)
                writeProguardDict(CLASS_PROGUARD_GENERATED_NAME)
                writeProguardDict(PACKAGE_PROGUARD_GENERATED_NAME)
            }
        }
    }

    private fun Project.writeProguardDict(dictName: String) {
        val dictFile = getRelativePath(dictName)
        deleteAndCreateNewFile(dictFile)
        val generateProguardDictionary = generateProguardDictionary()
        generateProguardDictionary.forEachIndexed { index, it ->
            dictFile.appendText(it)
            if (index != (generateProguardDictionary.size - 1)) {
                dictFile.appendText(System.lineSeparator())
            }
        }
    }
}