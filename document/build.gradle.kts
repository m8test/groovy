import com.m8test.gradle.ProjectSettings.debugMinifyEnabled
import com.m8test.gradle.ProjectSettings.releaseMinifyEnabled
import com.m8test.gradle.ProjectSettings.versions
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.m8test.groovy.document"
    compileSdk = versions.compile
    defaultConfig {
        minSdk = versions.mini
        targetSdk = versions.target
        versionCode = versions.groovy.document.code
        versionName = versions.groovy.document.name
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    // Create a variable called keystorePropertiesFile, and initialize it to your
    // keystore.properties file, in the rootProject folder.
    val keystorePropertiesFile = rootProject.file("local.properties")
    // Initialize a new Properties() object called keystoreProperties.
    val keystoreProperties = Properties()
    // Load your keystore.properties file into the keystoreProperties object.
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    signingConfigs {
        create("release") {
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = rootProject.file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }
    }
    buildTypes {
        debug {
            isMinifyEnabled = debugMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = true
        }
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = releaseMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
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

    compileOptions {
        sourceCompatibility(versions.javaSourceCompatibility)
        targetCompatibility(versions.javaTargetCompatibility)
    }

    kotlinOptions {
        jvmTarget = versions.jvmTarget
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}