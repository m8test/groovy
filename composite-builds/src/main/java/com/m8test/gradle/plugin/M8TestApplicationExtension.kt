package com.m8test.gradle.plugin

import com.m8test.gradle.ProjectSettings
import com.m8test.gradle.plugin.AndroidApplicationPlugin.Companion.android
import com.m8test.gradle.plugin.Utils.getProguardGeneratedFile
import org.gradle.api.Project

/**
 * Author: HyLee
 * Date: 2024/5/14 17:21
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: M8Test 安卓 application 扩展
 */
open class M8TestApplicationExtension {
    private var _useGeneratedProguardFile = false
    internal val useGeneratedProguardFile: Boolean
        get() = _useGeneratedProguardFile

    /**
     * 调用此方法表示根据abi分割apk
     * @receiver Project
     */
    fun Project.splitApk() {
        android {
            splits {
                abi {
                    isEnable = true
                    reset()
                    include(*ProjectSettings.releaseAbis)
                    isUniversalApk = true
                }
            }
        }
    }

    /**
     * 调用此方法则表示使用生成的 proguard 字典
     * @receiver Project
     */
    fun Project.generateProguardFile() {
        _useGeneratedProguardFile = true
        // 在这里设置proguard不生效
        android {
            buildTypes.forEach {
                with(it) {
                    if (isMinifyEnabled) {
                        val proguardFile = getProguardGeneratedFile()
                        proguardFiles.firstOrNull { p -> p.canonicalPath == proguardFile.canonicalPath }
                        proguardFile(proguardFile)
                    }
                }
            }
        }
    }
}