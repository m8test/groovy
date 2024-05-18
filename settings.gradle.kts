import org.gradle.api.initialization.resolve.RepositoriesMode

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
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
    versionCatalogs {
        create("m8test") {
            from(files("./libs.versions.toml"))
        }
    }
}

include(":document")
include(":sample")
includeBuild("composite-builds")