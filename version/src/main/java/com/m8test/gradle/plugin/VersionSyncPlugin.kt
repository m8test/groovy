package com.m8test.gradle.plugin

import com.m8test.gradle.ProjectSettings
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Author: HyLee
 * Date: 2023/9/4 15:21
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: TODO
 */
class VersionSyncPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("version sync plugin start...")
        target.sync()
        println("version sync plugin end...")
    }

    private fun Project.sync() {
        //在这个例子里用不到这个语句，该语句的作用是全局移除某个依赖
//        all*.exclude group: 'androidx.navigation', module: 'navigation-fragment'
//        all*.exclude group: 'com.google.guava', module: 'listenablefuture'
        subprojects {
            project.configurations.configureEach {
                resolutionStrategy.eachDependency {
                    val moduleName = requested.module.name
                    val groupName = requested.group
                    if (groupName == "com.android.support:appcompat-v7") {
                        useVersion(ProjectSettings.versions.SupportLibVersion)
                    } else if (groupName == "com.android.support:appcompat-v4") {
                        useVersion(ProjectSettings.versions.SupportLibVersion)
                    } else if (groupName == "androidx.activity") {
                        useVersion(ProjectSettings.versions.androidxActivity)
                    } else if (groupName == "com.google.accompanist") {
                        if (moduleName == "accompanist-coil") {
                            useVersion(ProjectSettings.versions.accompanistCoil)
                        } else if (moduleName == "accompanist-webview") {
                            useVersion(ProjectSettings.versions.accompanistWebView)
                        }
                    } else if (groupName == "androidx.annotation") {
                        if (moduleName == "annotation") {
                            useVersion(ProjectSettings.versions.androidxAnnotation)
                        }
                    } else if (groupName == "androidx.appcompat") {
                        useVersion(ProjectSettings.versions.androidxAppcompat)
                    } else if (groupName == "androidx.arch.core") {
                        useVersion(ProjectSettings.versions.androidxArchCore)
                    } else if (groupName == "androidx.cardview") {
                        useVersion(ProjectSettings.versions.androidxCardView)
                    } else if (groupName == "androidx.collection") {
                        useVersion(ProjectSettings.versions.androidxCollection)
                    } else if (groupName == "androidx.compose.animation") {
                        useVersion(ProjectSettings.versions.androidxComposeAnimation)
                    } else if (groupName == "androidx.compose.compiler") {
                        useVersion(ProjectSettings.versions.androidxComposeCompiler)
                    } else if (groupName == "androidx.compose.foundation") {
                        useVersion(ProjectSettings.versions.androidxComposeFoundation)
                    } else if (groupName == "androidx.compose.material") {
                        useVersion(ProjectSettings.versions.androidxComposeMaterial)
                    } else if (groupName == "androidx.compose.material3") {
                        useVersion(ProjectSettings.versions.androidxComposeMaterial3)
                    } else if (groupName == "androidx.compose.runtime") {
                        useVersion(ProjectSettings.versions.androidxComposeRuntime)
                    } else if (groupName == "androidx.compose.ui") {
                        useVersion(ProjectSettings.versions.androidxComposeUi)
                    } else if (groupName == "androidx.constraintlayout") {
                        if (moduleName == "constraintlayout") {
                            useVersion(ProjectSettings.versions.androidxConstraintLayout)
                        }
                    } else if (groupName == "androidx.coordinatorlayout") {
                        useVersion(ProjectSettings.versions.androidxCoordinatorLayout)
                    } else if (groupName == "androidx.core") {
                        useVersion(ProjectSettings.versions.androidxCore)
                    } else if (groupName == "androidx.cursoradapter") {
                        useVersion(ProjectSettings.versions.androidxCursorAdapter)
                    } else if (groupName == "androidx.customview") {
//                useVersion(versions.androidxCustomView
                    } else if (groupName == "androidx.drawerlayout") {
                        useVersion(ProjectSettings.versions.androidxDrawerlayout)
                    } else if (groupName == "androidx.exifinterface") {
                        useVersion(ProjectSettings.versions.androidxExifinterface)
                    } else if (groupName == "androidx.fragment") {
                        useVersion(ProjectSettings.versions.androidxFragment)
                    } else if (groupName == "androidx.legacy") {
                        useVersion(ProjectSettings.versions.androidxLegacy)
                    } else if (groupName == "androidx.lifecycle") {
                        useVersion(ProjectSettings.versions.androidxLifecycle)
                    } else if (groupName == "androidx.multidex") {
                        useVersion(ProjectSettings.versions.androidxMultiDex)
                    } else if (groupName == "androidx.navigation") {
                        useVersion(ProjectSettings.versions.androidXNavigation)
                    } else if (groupName == "androidx.room") {
                        useVersion(ProjectSettings.versions.roomVersion)
                    } else if (groupName == "androidx.savedstate") {
                        useVersion(ProjectSettings.versions.androidxSavedState)
                    } else if (groupName == "androidx.startup") {
                        useVersion(ProjectSettings.versions.androidxStartUp)
                    } else if (groupName == "androidx.test") {
                        if (moduleName == "monitor") {
                            useVersion(ProjectSettings.versions.androidxTestMonitor)
                        }
                    } else if (groupName == "androidx.test.espresso") {
                        useVersion(ProjectSettings.versions.androidxTestEspresso)
                    } else if (groupName == "androidx.test.ext") {
                        useVersion(ProjectSettings.versions.androidxTestExt)
                    } else if (groupName == "androidx.transition") {
                        useVersion(ProjectSettings.versions.androidxTransition)
                    } else if (groupName == "androidx.vectordrawable") {
                        useVersion(ProjectSettings.versions.androidxVectorDrawable)
                    } else if (groupName == "androidx.webkit") {
                        useVersion(ProjectSettings.versions.androidxWebKit)
                    } else if (groupName == "androidx.work") {
                        useVersion(ProjectSettings.versions.androidxWork)
                    } else if (groupName == "com.google.android.material") {
                        useVersion(ProjectSettings.versions.comGoogleAndroidMaterial)
                    } else if (groupName == "com.github.bumptech.glide") {
                        useVersion(ProjectSettings.versions.glide)
                    } else if (groupName == "com.google.code.findbugs") {
                        useVersion(ProjectSettings.versions.findbugs)
                    } else if (groupName == "com.squareup.okhttp3") {
                        useVersion(ProjectSettings.versions.okhttp)
                    } else if (groupName == "com.squareup.okio") {
                        useVersion(ProjectSettings.versions.okio)
                    } else if (groupName == "joda-time") {
                        useVersion(ProjectSettings.versions.jodaTime)
                    } else if (groupName == "org.jruby") {
                        useVersion(ProjectSettings.versions.jruby)
                    } else if (groupName == "com.smallbuer") {
                        if (moduleName == "jsbridge") {
                            useVersion(ProjectSettings.versions.jsbridge)
                        }
                    } else if (groupName == "net.minidev") {
                        if (moduleName == "json-smart") {
                            useVersion(ProjectSettings.versions.jsonSmart)
                        }
                    } else if (groupName == "junit") {
                        useVersion(ProjectSettings.versions.junit)
                    } else if (groupName == "org.slf4j") {
                        useVersion(ProjectSettings.versions.slf4j)
                    } else if (groupName == "org.jetbrains.kotlin") {
                        if (moduleName == "kotlin-stdlib" || moduleName == "kotlin-stdlib-jdk7" || moduleName == "kotlin-stdlib-jdk8" || moduleName == "kotlin-stdlib-common" || moduleName == "kotlin-reflect") {
                            useVersion(ProjectSettings.versions.kotlin_version)
                        }
                    } else if (groupName == "org.jetbrains.kotlinx") {
                        if (moduleName == "kotlinx-coroutines-android"
                            || moduleName == "kotlinx-coroutines-core"
                            || moduleName == "kotlinx-coroutines-bom"
                        ) {
                            useVersion(ProjectSettings.versions.kotlinxCoroutinesAndroid)
                        }
                    } else if (groupName == "com.iqiyi.xcrash") {
                        useVersion(ProjectSettings.versions.xcrash)
                    } else if (groupName == "com.github.yalantis") {
                        if (moduleName == "ucrop") {
                            useVersion(ProjectSettings.versions.ucrop)
                        }
                    } else if (groupName == "org.apache.commons") {
                        if (moduleName == "commons-lang3") {
                            useVersion(ProjectSettings.versions.orgApacheCommonsLang3)
                        }
                    } else if (groupName == "commons-io") {
                        if (moduleName == "commons-io") {
                            useVersion(ProjectSettings.versions.commonsIO)
                        }
                    } else if (groupName == "com.squareup.retrofit2") {
                        useVersion(ProjectSettings.versions.comSquareupRetrofit2)
                    } else if (groupName == "com.afollestad.material-dialogs") {
                        useVersion(ProjectSettings.versions.comAfollestadMaterialDialogs)
                    } else if (groupName == "com.google.code.gson") {
                        useVersion(ProjectSettings.versions.gson)
                    } else if (groupName == "com.google.mlkit") {
                        if (moduleName == "text-recognition") {
                            useVersion(ProjectSettings.versions.mlkit)
                        }
                    } else if (groupName == "com.google.guava") {
                        if (moduleName == "guava") {
                            useVersion(ProjectSettings.versions.guava)
                        }
                    } else if (groupName == "com.google.android.tools") {
                        if (moduleName == "dx") {
                            useVersion(ProjectSettings.versions.androidDx)
                        }
                    } else if (groupName == "org.bouncycastle") {
                        useVersion(ProjectSettings.versions.bouncycastle)
                    } else if (groupName == "org.ow2.asm") {
                        useVersion(ProjectSettings.versions.asm)
                    } else if (groupName == "net.bytebuddy") {
                        useVersion(ProjectSettings.versions.bytebuddy)
                    } else if (groupName == "com.blankj") {
                        useVersion(ProjectSettings.versions.utilCodex)
                    } else if (groupName == "org.conscrypt") {
                        useVersion(ProjectSettings.versions.conscryptAndroid)
                    } else if (groupName == "com.github.getActivity") {
                        if (moduleName == "Toaster") {
                            useVersion(ProjectSettings.versions.Toaster)
                        } else if (moduleName == "XXPermissions") {
                            useVersion(ProjectSettings.versions.XXPermissions)
                        }
                    } else if (groupName == "io.coil-kt") {
                        useVersion(ProjectSettings.versions.coil)
                    } else if (groupName == "io.netty") {
                        useVersion(ProjectSettings.versions.netty)
                    }
                }
            }
        }
    }
}