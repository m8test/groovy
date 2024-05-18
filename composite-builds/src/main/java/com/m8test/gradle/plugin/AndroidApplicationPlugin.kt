package com.m8test.gradle.plugin

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.m8test.gradle.ProjectSettings
import com.m8test.gradle.Versions
import com.m8test.gradle.plugin.Utils.commonProguardFile
import com.m8test.gradle.plugin.Utils.getProguardGeneratedFile
import com.m8test.gradle.plugin.Utils.registerGenerateProguardDictionaryTask
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import java.io.FileInputStream
import java.util.Properties

/**
 * Author: HyLee
 * Date: 2024/5/8 16:34
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: android application 共有属性
 */
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("android application")
        target.applyPlugin()
    }

    private fun Project.applyPlugin() {
        apply {
            plugin("com.android.application")
            plugin("org.jetbrains.kotlin.android")
            plugin("kotlin-android")
            plugin("com.google.devtools.ksp")
        }
        createExtension()
        registerGenerateProguardDictionaryTask()
        configAndroid()
        afterEvaluate {
            if (m8testApplication.useGeneratedProguardFile) {
                getAllTasks(true).firstNotNullOfOrNull {
                    it.value.firstOrNull { task -> task.name.endsWith("extractProguardFiles") }
                }?.let { t ->
                    getAllTasks(true).firstNotNullOfOrNull {
                        it.value.firstOrNull { task -> task.name.endsWith("generateProguardFile") }
                    }?.let {
                        t.dependsOn(it)
                    }
                }
            }
        }
    }

    private fun Project.createExtension() {
        extensions.create(VAR_NAME, M8TestApplicationExtension::class.java)
    }

    /**
     * 配置通用的 android
     * @receiver Project
     */
    private fun Project.configAndroid() {
        android {
            compileSdk = Versions.compile
            defaultConfig {
                minSdk = Versions.mini
                targetSdk = Versions.target
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    commonProguardFile(),
                    "proguard-rules.pro",
                )
            }

            compileOptions {
                sourceCompatibility = Versions.javaSourceCompatibility
                targetCompatibility = Versions.javaTargetCompatibility
            }

            kotlinOptions {
                jvmTarget = Versions.jvmTarget
            }

            buildFeatures {
                buildConfig = true
            }

            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = ProjectSettings.debugMinifyEnabled
                    isDebuggable = true
                    if (isMinifyEnabled) {
                        proguardFile(getProguardGeneratedFile())
                    }
                }
                val releaseBuildTypeName = "release"
                getByName(releaseBuildTypeName) {
                    createSignConfig(releaseBuildTypeName)
                    signingConfig = signingConfigs.getByName(releaseBuildTypeName)
                    isMinifyEnabled = ProjectSettings.releaseMinifyEnabled
                    isDebuggable = false
                    if (isMinifyEnabled) {
                        proguardFile(getProguardGeneratedFile())
                    }
                }
            }

            packaging {
                resources {
                    excludes += "META-INF/INDEX.LIST"
                    excludes += "META-INF/io.netty.versions.properties"
                }
            }

            android.applicationVariants.all {
                val variant = this
                outputs.all {
                    var abi = ""
                    if (filters != null && filters.isNotEmpty()) {
                        abi = "-${filters.toTypedArray()[0].identifier}"
                    }
                    if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                        outputFileName =
                            "${namespace}${abi}-${variant.buildType.name}_${defaultConfig.versionName}.apk"
                    }
                }
            }
        }
    }

    private fun Project.createSignConfig(name: String) {
        android {
            // Create a variable called keystorePropertiesFile, and initialize it to your
            // keystore.properties file, in the rootProject folder.
            val keystorePropertiesFile = rootProject.file("local.properties")
            // Initialize a new Properties() object called keystoreProperties.
            val keystoreProperties = Properties()
            // Load your keystore.properties file into the keystoreProperties object.
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))
            signingConfigs {
                create(name) {
                    keyAlias = keystoreProperties["keyAlias"] as String
                    keyPassword = keystoreProperties["keyPassword"] as String
                    storeFile = rootProject.file(keystoreProperties["storeFile"] as String)
                    storePassword = keystoreProperties["storePassword"] as String
                }
            }
        }
    }


    /**
     * Configures the [kotlinOptions][org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions] extension.
     */
    private fun BaseAppModuleExtension.`kotlinOptions`(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
        (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

    companion object {
        private const val VAR_NAME = "m8testApplication"
        val Project.m8testApplication: M8TestApplicationExtension
            get() = (extensions.getByName(VAR_NAME) as M8TestApplicationExtension)

        fun Project.m8testApplication(configure: Action<M8TestApplicationExtension>): Unit =
            extensions.configure(VAR_NAME, configure)

        /**
         * Configures the [android][com.android.build.gradle.internal.dsl.BaseAppModuleExtension] extension.
         */
        fun Project.`android`(configure: Action<BaseAppModuleExtension>): Unit =
            (this as ExtensionAware).extensions.configure("android", configure)

        /**
         * Retrieves the [android][com.android.build.gradle.LibraryExtension] extension.
         */
        val Project.`android`: BaseAppModuleExtension
            get() = (this as ExtensionAware).extensions.getByName("android") as BaseAppModuleExtension
    }
}