plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

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
    implementation(gradleApi())
}

gradlePlugin {
    plugins {
        register("version") {
            id = "com.m8test.gradle.version"
            implementationClass = "com.m8test.gradle.plugin.VersionSyncPlugin"
        }
    }
}