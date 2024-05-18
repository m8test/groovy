package com.m8test.gradle.plugin

import com.android.build.gradle.LibraryExtension
import com.m8test.gradle.Versions
import com.m8test.gradle.plugin.Utils.commonProguardFile
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

/**
 * Author: HyLee
 * Date: 2024/5/8 16:34
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: android library 共有属性
 */
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("android library")
        target.applyPlugin()
    }

    private fun Project.applyPlugin() {
        apply {
            plugin("com.android.library")
            plugin("org.jetbrains.kotlin.android")
            plugin("kotlin-android")
            plugin("com.google.devtools.ksp")
        }
        configAndroid()
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
                lint.targetSdk = Versions.target
                testOptions.targetSdk = Versions.target
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFile(commonProguardFile())
                consumerProguardFile("proguard-rules.pro")
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    commonProguardFile(),
                    "proguard-rules.pro",
                )
            }

            buildTypes {
                getByName("debug") {
//                    if (ProjectSettings.debugMinifyEnabled) {
//                        registerGenerateProguardDictionaryTask()
//                        consumerProguardFile(getProguardGeneratedFile())
//                    }
                }
                getByName("release") {
//                    if (ProjectSettings.releaseMinifyEnabled) {
//                        registerGenerateProguardDictionaryTask()
//                        consumerProguardFile(getProguardGeneratedFile())
//                    }
                }
            }

            compileOptions {
                sourceCompatibility(Versions.javaSourceCompatibility)
                targetCompatibility(Versions.javaTargetCompatibility)
            }

            buildFeatures {
                buildConfig = true
            }

            kotlinOptions {
                jvmTarget = Versions.jvmTarget
            }
        }
    }

    /**
     * Configures the [android][com.android.build.gradle.LibraryExtension] extension.
     */
    private fun Project.`android`(configure: Action<LibraryExtension>): Unit =
        (this as ExtensionAware).extensions.configure("android", configure)

    /**
     * Configures the [kotlinOptions][org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions] extension.
     */
    private fun LibraryExtension.`kotlinOptions`(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions>): Unit =
        (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
}