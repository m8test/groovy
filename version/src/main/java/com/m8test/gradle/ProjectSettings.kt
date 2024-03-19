package com.m8test.gradle

import org.gradle.api.JavaVersion

/**
 * Author= HyLee
 * Date= 2023/9/3 21=54
 * Email= hylee_lhy@qq.com
 * Address= https=//xiaoheidiannao.com
 * Description= TODO
 */
object ProjectSettings {

    const val debugMinifyEnabled = false
    const val releaseMinifyEnabled = true

    val releaseAbis = arrayOf("x86", "x86_64", "armeabi-v7a", "arm64-v8a")

    object versions {
        data class Version(val code: Int, val name: String)
        object groovy {
            val document = Version(code = 1, name = "0.1.0")
            val sample = Version(code = 1, name = "0.1.0")
        }

        val javaSourceCompatibility = JavaVersion.VERSION_11
        val javaTargetCompatibility = JavaVersion.VERSION_11
        const val kotlin_version = "1.9.10"
        const val agp = "8.1.1"
        const val jvmTarget = "11"
        const val appVersionCode = 1
        const val appVersionName = "vermouth"
        const val target = 34
        const val mini = 21
        const val compile = 34
        const val conscryptAndroid = "2.5.2"
        const val ndkVersion = "25.2.9519653"
        const val cmakeVersion = "3.22.1"
        const val buildTool = "34.0.0"
        const val accompanistCoil = "0.15.0"
        const val accompanistWebView = "0.28.0"
        const val androidxActivity = "1.7.2"
        const val androidxAnnotation = "1.6.0"
        const val androidxAppcompat = "1.6.1"
        const val androidxArchCore = "2.1.0"
        const val androidxAsyncLayoutInflater = "1.0.0"
        const val androidxCardView = "1.0.0"
        const val androidxCollection = "1.2.0"
        const val androidxComposeAnimation = "1.3.2"
        const val androidxComposeFoundation = "1.3.1"
        const val androidxComposeMaterial = "1.3.1"
        const val androidxComposeMaterial3 = "1.0.1"
        const val androidxComposeCompiler = "1.3.2"
        const val androidxComposeRuntime = "1.3.2"
        const val androidxComposeUi = "1.3.2"
        const val androidxConstraintLayout = "2.1.3"
        const val androidxConstraintLayoutCompose = "1.0.0"
        const val androidxCoordinatorLayout = "1.2.0"
        const val androidxCore = "1.10.1"
        const val androidxCursorAdapter = "1.0.0"
        const val androidWebKit = "1.7.0"

        //            androidxCustomView            ="1.1.0"
        const val androidxDrawerlayout = "1.2.0"
        const val androidxExifinterface = "1.3.3"
        const val androidxFragment = "1.4.1"
        const val androidxLegacy = "1.0.0"
        const val androidxLifecycle = "2.6.1"
        const val androidxMultiDex = "2.0.1"
        const val androidXNavigation = "2.5.3"
        const val androidxSavedState = "1.2.0"
        const val androidxStartUp = "1.1.1"
        const val androidxTestMonitor = "1.5.0"
        const val androidxTestEspresso = "3.5.1"
        const val androidxTestExt = "1.1.5"
        const val androidxTransition = "1.4.1"
        const val androidxVectorDrawable = "1.1.0"
        const val androidxWebKit = "1.7.0"
        const val androidxWork = "2.8.1"
        const val androidDx = "1.7"
        const val asm = "9.3"
        const val bouncycastle = "1.70"
        const val bytebuddy = "1.12.10"
        const val comGoogleAndroidMaterial = "1.9.0"
        const val commonsIO = "2.11.0"
        const val comSquareupRetrofit2 = "2.9.0"
        const val comAfollestadMaterialDialogs = "0.9.2.3"
        const val coil = "2.2.2"
        const val glide = "4.8.0"
        const val gson = "2.8.9"
        const val guava = "31.1-android"
        const val findbugs = "3.0.1"
        const val jodaTime = "2.9.9"
        const val jruby = "1.7.27"
        const val jsbridge = "1.0.7"
        const val jsonSmart = "2.5.0"
        const val junit = "4.13.2"
        const val ktor = "2.3.2"
        const val mlkit = "16.0.0"
        const val netty = "4.1.91.Final"
        const val okhttp = "4.9.3"
        const val okio = "3.1.0"
        const val roomVersion = "2.5.2"
        const val slf4j = "1.7.25"
        const val kotlinxCoroutinesAndroid = "1.6.1"
        const val xcrash = "3.0.0"
        const val ucrop = "2.2.8"
        const val utilCodex = "1.31.1"
        const val orgApacheCommonsLang3 = "3.9"
        const val SupportLibVersion = "28.0.0"
        const val XXPermissions = "18.2"
        const val Toaster = "12.0"
        const val jsch = "0.2.11"
    }
}
