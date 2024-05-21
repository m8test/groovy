plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    // jcenter()
    google()
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:${m8test.versions.agp.get()}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${m8test.versions.kotlinVersion.get()}")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${m8test.versions.kotlinVersion.get()}-1.0.20")
}

gradlePlugin {
    plugins {
        register("versionSync") {
            id = "com.m8test.gradle.version.sync"
            implementationClass = "com.m8test.gradle.plugin.VersionSyncPlugin"
        }
        register("androidLibrary") {
            id = "com.m8test.gradle.android.library"
            implementationClass = "com.m8test.gradle.plugin.AndroidLibraryPlugin"
        }
        register("androidApplication") {
            id = "com.m8test.gradle.android.application"
            implementationClass = "com.m8test.gradle.plugin.AndroidApplicationPlugin"
        }
    }
}