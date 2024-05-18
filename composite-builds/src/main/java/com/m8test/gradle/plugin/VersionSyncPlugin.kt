package com.m8test.gradle.plugin

import com.m8test.gradle.Versions
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
        allprojects {
            project.configurations.configureEach {
                resolutionStrategy.eachDependency {
                    val moduleName = requested.module.name
                    val groupName = requested.group
                    if (groupName == "com.android.support:appcompat-v7") {
                        useVersion(Versions.SupportLibVersion)
                    } else if (groupName == "com.android.support:appcompat-v4") {
                        useVersion(Versions.SupportLibVersion)
                    } else if (groupName == "androidx.activity") {
                        useVersion(Versions.androidxActivity)
                    } else if (groupName == "com.google.accompanist") {
                        if (moduleName == "accompanist-coil") {
                            useVersion(Versions.accompanistCoil)
                        } else if (moduleName == "accompanist-webview") {
                            useVersion(Versions.accompanistWebView)
                        }
                    } else if (groupName == "androidx.annotation") {
                        if (moduleName == "annotation") {
                            useVersion(Versions.androidxAnnotation)
                        }
                    } else if (groupName == "androidx.appcompat") {
                        useVersion(Versions.androidxAppcompat)
                    } else if (groupName == "androidx.arch.core") {
                        useVersion(Versions.androidxArchCore)
                    } else if (groupName == "androidx.cardview") {
                        useVersion(Versions.androidxCardView)
                    } else if (groupName == "androidx.collection") {
                        useVersion(Versions.androidxCollection)
                    } else if (groupName == "androidx.compose.animation") {
                        useVersion(Versions.androidxComposeAnimation)
                    } else if (groupName == "androidx.compose.compiler") {
                        useVersion(Versions.androidxComposeCompiler)
                    } else if (groupName == "androidx.compose.foundation") {
                        useVersion(Versions.androidxComposeFoundation)
                    } else if (groupName == "androidx.compose.material") {
                        useVersion(Versions.androidxComposeMaterial)
                    } else if (groupName == "androidx.compose.material3") {
                        useVersion(Versions.androidxComposeMaterial3)
                    } else if (groupName == "androidx.compose.runtime") {
                        useVersion(Versions.androidxComposeRuntime)
                    } else if (groupName == "androidx.compose.ui") {
                        useVersion(Versions.androidxComposeUi)
                    } else if (groupName == "androidx.constraintlayout") {
                        if (moduleName == "constraintlayout") {
                            useVersion(Versions.androidxConstraintLayout)
                        }
                    } else if (groupName == "androidx.coordinatorlayout") {
                        useVersion(Versions.androidxCoordinatorLayout)
                    } else if (groupName == "androidx.core") {
                        useVersion(Versions.androidxCore)
                    } else if (groupName == "androidx.cursoradapter") {
                        useVersion(Versions.androidxCursorAdapter)
                    } else if (groupName == "androidx.customview") {
//                        useVersion(ProjectSettings.versions.androidxCustomView)
                    } else if (groupName == "androidx.drawerlayout") {
                        useVersion(Versions.androidxDrawerlayout)
                    } else if (groupName == "androidx.exifinterface") {
                        useVersion(Versions.androidxExifinterface)
                    } else if (groupName == "androidx.fragment") {
                        useVersion(Versions.androidxFragment)
                    } else if (groupName == "androidx.legacy") {
                        useVersion(Versions.androidxLegacy)
                    } else if (groupName == "androidx.lifecycle") {
                        if (moduleName == "lifecycle-extensions") {
                            useVersion(Versions.androidxLifecycleExtensions)
                        } else {
                            useVersion(Versions.androidxLifecycle)
                        }
                    } else if (groupName == "androidx.multidex") {
                        useVersion(Versions.androidxMultiDex)
                    } else if (groupName == "androidx.navigation") {
                        useVersion(Versions.androidXNavigation)
                    } else if (groupName == "androidx.room") {
                        useVersion(Versions.roomVersion)
                    } else if (groupName == "androidx.savedstate") {
                        useVersion(Versions.androidxSavedState)
                    } else if (groupName == "androidx.startup") {
                        useVersion(Versions.androidxStartUp)
                    } else if (groupName == "androidx.test") {
                        if (moduleName == "monitor") {
                            useVersion(Versions.androidxTestMonitor)
                        }
                    } else if (groupName == "androidx.test.espresso") {
                        useVersion(Versions.androidxTestEspresso)
                    } else if (groupName == "androidx.test.ext") {
                        useVersion(Versions.androidxTestExt)
                    } else if (groupName == "androidx.transition") {
                        useVersion(Versions.androidxTransition)
                    } else if (groupName == "androidx.vectordrawable") {
                        useVersion(Versions.androidxVectorDrawable)
                    } else if (groupName == "androidx.webkit") {
                        useVersion(Versions.androidxWebKit)
                    } else if (groupName == "androidx.work") {
                        useVersion(Versions.androidxWork)
                    } else if (groupName == "com.google.android.material") {
                        useVersion(Versions.comGoogleAndroidMaterial)
                    } else if (groupName == "com.github.bumptech.glide") {
                        useVersion(Versions.glide)
                    } else if (groupName == "com.google.code.findbugs") {
                        useVersion(Versions.findbugs)
                    } else if (groupName == "com.squareup.okhttp3") {
                        useVersion(Versions.okhttp)
                    } else if (groupName == "com.squareup.okio") {
                        useVersion(Versions.okio)
                    } else if (groupName == "joda-time") {
                        useVersion(Versions.jodaTime)
                    } else if (groupName == "org.jruby") {
                        useVersion(Versions.jruby)
                    } else if (groupName == "com.smallbuer") {
                        if (moduleName == "jsbridge") {
                            useVersion(Versions.jsbridge)
                        }
                    } else if (groupName == "net.minidev") {
                        if (moduleName == "json-smart") {
                            useVersion(Versions.jsonSmart)
                        }
                    } else if (groupName == "junit") {
                        useVersion(Versions.junit)
                    } else if (groupName == "org.slf4j") {
                        useVersion(Versions.slf4j)
                    } else if (groupName == "org.jetbrains.kotlin") {
                        if (moduleName == "kotlin-stdlib" || moduleName == "kotlin-stdlib-jdk7" || moduleName == "kotlin-stdlib-jdk8" || moduleName == "kotlin-stdlib-common" || moduleName == "kotlin-reflect") {
                            useVersion(Versions.kotlinVersion)
                        }
                    } else if (groupName == "org.jetbrains.kotlinx") {
                        if (moduleName == "kotlinx-coroutines-android"
                            || moduleName == "kotlinx-coroutines-core"
                            || moduleName == "kotlinx-coroutines-bom"
                        ) {
                            useVersion(Versions.kotlinxCoroutinesAndroid)
                        }
                    } else if (groupName == "com.iqiyi.xcrash") {
                        useVersion(Versions.xcrash)
                    } else if (groupName == "com.github.yalantis") {
                        if (moduleName == "ucrop") {
                            useVersion(Versions.ucrop)
                        }
                    } else if (groupName == "org.apache.commons") {
                        if (moduleName == "commons-lang3") {
                            useVersion(Versions.orgApacheCommonsLang3)
                        }
                    } else if (groupName == "commons-io") {
                        if (moduleName == "commons-io") {
                            useVersion(Versions.commonsIO)
                        }
                    } else if (groupName == "com.squareup.retrofit2") {
                        useVersion(Versions.comSquareupRetrofit2)
                    } else if (groupName == "com.afollestad.material-dialogs") {
                        useVersion(Versions.comAfollestadMaterialDialogs)
                    } else if (groupName == "com.google.code.gson") {
                        useVersion(Versions.gson)
                    } else if (groupName == "com.google.mlkit") {
                        if (moduleName == "text-recognition") {
                            useVersion(Versions.mlkit)
                        }
                    } else if (groupName == "com.google.guava") {
                        if (moduleName == "guava") {
                            useVersion(Versions.guava)
                        }
                    } else if (groupName == "com.google.android.tools") {
                        if (moduleName == "dx") {
                            useVersion(Versions.androidDx)
                        }
                    } else if (groupName == "org.bouncycastle") {
                        useVersion(Versions.bouncycastle)
                    } else if (groupName == "org.ow2.asm") {
                        useVersion(Versions.asm)
                    } else if (groupName == "net.bytebuddy") {
                        useVersion(Versions.bytebuddy)
                    } else if (groupName == "com.blankj") {
                        useVersion(Versions.utilCodex)
                    } else if (groupName == "org.conscrypt") {
                        useVersion(Versions.conscryptAndroid)
                    } else if (groupName == "com.github.getActivity") {
                        if (moduleName == "Toaster") {
                            useVersion(Versions.Toaster)
                        } else if (moduleName == "XXPermissions") {
                            useVersion(Versions.XXPermissions)
                        }
                    } else if (groupName == "io.coil-kt") {
                        useVersion(Versions.coil)
                    } else if (groupName == "io.netty") {
                        useVersion(Versions.netty)
                    }
                }
            }
        }
    }
}