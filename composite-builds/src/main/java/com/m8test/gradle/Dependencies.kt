package com.m8test.gradle

/**
 * Author: HyLee
 * Date: 2024/5/9 14:01
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: 项目中所用到的依赖
 */
object Dependencies {
    fun androidXRoomRuntime() = "androidx.room:room-runtime:${Versions.roomVersion}"
    fun androidXRoomCompiler() = "androidx.room:room-compiler:${Versions.roomVersion}"
    fun androidXCoreKtx() = "androidx.core:core-ktx:${Versions.androidxCore}"
    fun androidXAppCompat() = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    fun comGoogleAndroidMaterial() =
        "com.google.android.material:material:${Versions.comGoogleAndroidMaterial}"

    fun junit() = "junit:junit:${Versions.junit}"
    fun androidxTestExt() = "androidx.test.ext:junit:${Versions.androidxTestExt}"
    fun androidxTestEspresso() =
        "androidx.test.espresso:espresso-core:${Versions.androidxTestEspresso}"

    fun androidxComposeFoundation() =
        "androidx.compose.foundation:foundation:${Versions.androidxComposeFoundation}"

    fun androidxComposeMaterial() =
        "androidx.compose.material:material:${Versions.androidxComposeMaterial}"

    fun androidxComposeAnimation() =
        "androidx.compose.material:material:${Versions.androidxComposeAnimation}"

    fun androidxComposeUi() = "androidx.compose.ui:ui:${Versions.androidxComposeUi}"
    fun androidxComposeUiTooling() =
        "androidx.compose.ui:ui-tooling:${Versions.androidxComposeUi}"

    fun androidxComposeUiUtil() =
        "androidx.compose.ui:ui-util:${Versions.androidxComposeUi}"

    fun androidxComposeUiToolingPreview() =
        "androidx.compose.ui:ui-tooling-preview:${Versions.androidxComposeUi}"

    fun androidxComposeUiTestJunit4() =
        "androidx.compose.ui:ui-test-junit4:${Versions.androidxComposeUi}"

    fun androidxComposeUiTestManifest() =
        "androidx.compose.ui:ui-test-manifest:${Versions.androidxComposeUi}"

    fun androidxLifecycleViewModelCompose() =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidxLifecycle}"

    fun coroutinesAndroid() =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesAndroid}"

    fun androidxWebkit() =
        "androidx.webkit:webkit:${Versions.androidxWebKit}"

    fun androidxActivity() = "androidx.activity:activity-compose:${Versions.androidxActivity}"
    fun androidxAnnotation() = "androidx.annotation:annotation:${Versions.androidxAnnotation}"
    fun androidXNavigation() =
        "androidx.navigation:navigation-compose:${Versions.androidXNavigation}"

    fun accompanistCoil() =
        "com.google.accompanist:accompanist-coil:${Versions.accompanistCoil}"

    fun ktorServerCore() = "io.ktor:ktor-server-core:${Versions.ktor}"
    fun ktorServerNetty() = "io.ktor:ktor-server-netty:${Versions.ktor}"
    fun ktorServerForwardHeader() = "io.ktor:ktor-server-forwarded-header:${Versions.ktor}"
    fun ktorServerWebsockets() = "io.ktor:ktor-server-websockets:${Versions.ktor}"
    fun ktorServerStatusPage() = "io.ktor:ktor-server-status-pages:${Versions.ktor}"
    fun ktorClientCore() = "io.ktor:ktor-client-core:${Versions.ktor}"
    fun ktorClientOkhttp() = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    fun ktorClientWebsockets() = "io.ktor:ktor-client-websockets:${Versions.ktor}"
    fun ktorClientContentNegotiation() =
        "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"

    fun ktorClientSerializationGson() =
        "io.ktor:ktor-serialization-gson:${Versions.ktor}"

    fun gson() = "com.google.code.gson:gson:${Versions.gson}"
    fun composeDialogDateTime() =
        "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc"

    fun workRuntimeKtx() = "androidx.work:work-runtime-ktx:${Versions.androidxWork}"
    fun xxPermissions() = "com.github.getActivity:XXPermissions:${Versions.XXPermissions}"
    fun utilCodex() = "com.blankj:utilcodex:${Versions.utilCodex}"
    fun jodaTime() = "joda-time:joda-time:${Versions.jodaTime}"
    fun jsBridge() = "com.smallbuer:jsbridge:${Versions.jsbridge}"
    fun guaua() = "com.google.guava:guava:${Versions.guava}"
    fun toaster() = "com.github.getActivity:Toaster:${Versions.Toaster}"
    fun mixpanel() = "com.mixpanel.android:mixpanel-android:7.4.1"
    fun shake() = "com.shakebugs:shake:16.2.5"
    fun jsonSmart() = "net.minidev:json-smart:${Versions.jsonSmart}"
    fun logcat() = "com.github.getActivity:Logcat:${Versions.logcat}"
    fun desugarJdkLibs() = "com.android.tools:desugar_jdk_libs:2.0.4"
    fun appUpdater() = "com.github.jenly1314.AppUpdater:app-updater:1.2.0"
    fun firebaseBom() = "com.google.firebase:firebase-bom:32.8.1"
    fun sunSecurityAndroid() =
        "com.github.MuntashirAkon:sun-security-android:1.1"

    fun spake2Java() =
        "com.github.MuntashirAkon.spake2-java:android:7ec739b5c4"

    fun bouncycastle() =
        "org.bouncycastle:bcprov-jdk15on:${Versions.bouncycastle}"

    fun jsch() =
        "com.github.mwiede:jsch:${Versions.jsch}"

    fun accompanistPlaceholder() =
        "com.google.accompanist:accompanist-placeholder-material:0.28.0"

    fun coil() =
        "io.coil-kt:coil:${Versions.coil}"

    fun coilSvg() =
        "io.coil-kt:coil-svg:${Versions.coil}"

    fun coilCompose() =
        "io.coil-kt:coil-compose:${Versions.coil}"

    fun mlkit() =
        "com.google.mlkit:text-recognition:${Versions.mlkit}"

    fun mlkitChinese() =
        "com.google.mlkit:text-recognition-chinese:${Versions.mlkit}"

    fun tesseract4android() =
        "cz.adaptech:tesseract4android:4.1.1"

    fun jruby() =
        "org.jruby:jruby-complete:${Versions.jruby}"

    fun javetAndroidNode() =
        "com.caoccao.javet:javet-android-node:${Versions.javet}"

    fun javetAndroidV8() =
        "com.caoccao.javet:javet-android-v8:${Versions.javet}"

    fun javetCore() =
        "com.caoccao.javet:javet-core:${Versions.javet}"

    fun javetSwc4f() =
        "com.caoccao.javet:swc4j:0.1.0"

    fun threeten() =
        "org.threeten:threetenbp:1.6.0"

    fun hiddenapibypass() =
        "org.lsposed.hiddenapibypass:hiddenapibypass:4.3"

    fun nbJavacAndroid() =
        "io.github.itsaky:nb-javac-android:17.0.0.3"

    fun trove4j() =
        "org.jetbrains.intellij.deps:trove4j:1.0.20200330"

    fun jdom() =
        "org.jdom:jdom:2.0.2"

    fun kotlinReflect(kotlinVersion: String) =
        "org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}"

    fun slf4jApi() = "org.slf4j:slf4j-api:${Versions.slf4j}"

    fun kotlinScriptingJvmHost(kotlinVersion: String) =
        "org.jetbrains.kotlin:kotlin-scripting-jvm-host:$kotlinVersion"

    fun kotlinScriptingCompilerImpl(kotlinVersion: String) =
        "org.jetbrains.kotlin:kotlin-scripting-compiler-impl:$kotlinVersion"

    fun kotlinScriptingCompiler(kotlinVersion: String) =
        "org.jetbrains.kotlin:kotlin-scripting-compiler:$kotlinVersion"

    fun kotlinCompiler(kotlinVersion: String) =
        "org.jetbrains.kotlin:kotlin-compiler:$kotlinVersion"
}