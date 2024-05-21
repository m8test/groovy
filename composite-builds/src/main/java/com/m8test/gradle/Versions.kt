package com.m8test.gradle

import org.gradle.api.JavaVersion

/**
 * Author: HyLee
 * Date: 2023/10/22 10:49
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: 项目中所用到的依赖版本
 */
object Versions {
    val javaSourceCompatibility = JavaVersion.VERSION_11
    val javaTargetCompatibility = JavaVersion.VERSION_11
    const val kotlinVersion = "1.9.24"
    const val jvmTarget = "11"
    const val target = 34
    const val mini = 21
    const val compile = 34
    const val conscryptAndroid = "2.5.2"
    const val accompanistCoil = "0.15.0"
    const val accompanistWebView = "0.28.0"
    const val androidxActivity = "1.9.0"
    const val androidxAnnotation = "1.7.1"
    const val androidxAppcompat = "1.6.1"
    const val androidxArchCore = "2.2.0"
    const val androidxCardView = "1.0.0"
    const val androidxCollection = "1.4.0"
    const val androidxComposeAnimation = "1.6.6"
    const val androidxComposeFoundation = "1.6.6"
    const val androidxComposeMaterial = "1.6.6"
    const val androidxComposeMaterial3 = "1.2.1"
    const val androidxComposeCompiler = "1.5.11"
    const val androidxComposeRuntime = "1.6.6"
    const val androidxComposeUi = "1.6.6"
    const val androidxConstraintLayout = "2.1.4"
    const val androidxCoordinatorLayout = "1.2.0"
    const val androidxCore = "1.13.0"
    const val androidxCursorAdapter = "1.0.0"
    const val androidxDrawerlayout = "1.2.0"
    const val androidxExifinterface = "1.3.7"
    const val androidxFragment = "1.6.2"
    const val androidxLegacy = "1.0.0"
    const val androidxLifecycle = "2.7.0"
    const val androidxLifecycleExtensions = "2.2.0"
    const val androidxMultiDex = "2.0.1"
    const val androidXNavigation = "2.7.7"
    const val androidxSavedState = "1.2.1"
    const val androidxStartUp = "1.1.1"
    const val androidxTestMonitor = "1.6.1"
    const val androidxTestEspresso = "3.5.1"
    const val androidxTestExt = "1.1.5"
    const val androidxTransition = "1.4.1"
    const val androidxVectorDrawable = "1.1.0"
    const val androidxWebKit = "1.9.0"
    const val androidxWork = "2.9.0"
    const val androidDx = "1.7"
    const val asm = "9.3"
    const val bouncycastle = "1.70"
    const val bytebuddy = "1.12.10"
    const val comGoogleAndroidMaterial = "1.11.0"
    const val commonsIO = "2.11.0"
    const val comSquareupRetrofit2 = "2.9.0"
    const val comAfollestadMaterialDialogs = "0.9.2.3"
    const val coil = "2.2.2"
    const val glide = "4.8.0"
    const val gson = "2.10.1"
    const val guava = "31.1-android"
    const val findbugs = "3.0.1"
    const val jodaTime = "2.9.9"
    const val jruby = "1.7.27"
    const val jsbridge = "1.0.7"
    const val jsonSmart = "2.5.0"
    const val junit = "4.13.2"
    const val ktor = "2.3.9"
    const val logcat = "11.8"
    const val mlkit = "16.0.0"
    const val netty = "4.1.91.Final"
    const val okhttp = "4.9.3"
    const val okio = "3.1.0"
    const val roomVersion = "2.6.1"
    const val slf4j = "2.0.7"
    const val kotlinxCoroutinesAndroid = "1.8.0"
    const val xcrash = "3.0.0"
    const val ucrop = "2.2.8"
    const val utilCodex = "1.31.1"
    const val orgApacheCommonsLang3 = "3.9"
    const val SupportLibVersion = "28.0.0"
    const val XXPermissions = "18.2"
    const val Toaster = "12.0"
    const val jsch = "0.2.11"
    const val javet = "3.1.0"

    object groovy {
        val document = Version(code = 1, name = "0.1.0")
        val sample = Version(code = 1, name = "0.1.0")
    }

    data class Version(val code: Int, val name: String, val minSdk: Int = mini)
}