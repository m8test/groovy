package com.m8test.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
//import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create

/**
 * Author: HyLee
 * Date: 2023/9/4 15:29
 * Email: hylee_lhy@qq.com
 * Address: https://xiaoheidiannao.com
 * Description: TODO
 */
class PublishLocalPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("publish local plugin start...")
        target.publish()
        println("publish local plugin end...")
    }

    private fun Project.publish() {
        // 发布到本地仓库,需要通过clean任务,preBuild会报错
        apply(mapOf("plugin" to "maven-publish"))
        configure<PublishingExtension> {
//            val libsDirName = "aars"
            publications {
//                create<MavenPublication>("maven") {
//                    groupId = "com.m8test"
//                    artifactId = "javet"
//                    version = "1.0.7"
//                    artifact("$libsDirName/javet-android-1.0.7.aar")
//                }
                // and so on...
            }
        }

        // add the publication before the build even starts
        // used ./gradlew mymodule:assemble --dry-run to find where to put it
        afterEvaluate {
            tasks.getByName("clean").dependsOn("publishToMavenLocal")
//            tasks.build.finalizedBy(publishToMavenLocal)
//            tasks.preBuild.dependsOn("publishToMavenLocal")
        }


//dependencies {
//    implementation "org.opencv:opencv:3.4.3"
//    implementation "org.termexec:libtermexec:1.0.0"
//    implementation "org.term:term-debug:1.0.0"
//    // and so on
//    // also I had to make sure to add the aar"s transitive dependencies as implementation below
//}
    }
}