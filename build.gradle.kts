// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenLocal()
        // 添加阿里云 maven 地址
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        mavenCentral()
        maven("https://jitpack.io")
        // jcenter()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${m8test.versions.agp.get()}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${m8test.versions.kotlinVersion.get()}")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${m8test.versions.kotlinVersion.get()}-1.0.20")
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.layout.buildDirectory)
}

plugins {
    id("com.m8test.gradle.version.sync") apply false
}

apply(mapOf("plugin" to com.m8test.gradle.plugin.VersionSyncPlugin::class.java))
apply(mapOf("plugin" to com.m8test.gradle.plugin.PublishLocalPlugin::class.java))