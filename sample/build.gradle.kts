import com.m8test.gradle.Versions

plugins {
    id("com.m8test.gradle.android.application")
}

android {
    namespace = "com.m8test.groovy.sample"
    defaultConfig {
        versionCode = Versions.groovy.sample.code
        versionName = Versions.groovy.sample.name
    }
}