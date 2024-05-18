dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://jitpack.io")
        // jcenter()
        google()
    }
    versionCatalogs {
        create("m8test") {
            from(files("../libs.versions.toml"))
        }
    }
}

rootProject.name = "composite-builds"