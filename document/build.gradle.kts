import com.m8test.gradle.Versions

plugins {
    id("com.m8test.gradle.android.application")
}

android {
    namespace = "com.m8test.groovy.document"
    defaultConfig {
        versionCode = Versions.groovy.document.code
        versionName = Versions.groovy.document.name
    }
}