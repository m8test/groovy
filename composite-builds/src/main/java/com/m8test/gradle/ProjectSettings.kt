package com.m8test.gradle

/**
 * Author= HyLee
 * Date= 2023/9/3 21=54
 * Email= hylee_lhy@qq.com
 * Address= https=//xiaoheidiannao.com
 * Description= TODO
 */
object ProjectSettings {
    const val debugMinifyEnabled = false
    const val releaseMinifyEnabled = true
    val releaseAbis = arrayOf("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
}
