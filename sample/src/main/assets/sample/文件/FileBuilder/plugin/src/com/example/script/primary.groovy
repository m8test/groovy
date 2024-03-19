package com.example.script

/*
功能:
+ 配置文件路径为项目插件路径,只有在工程脚本中才能使用,文件或者字符串脚本无法调用此方法

定义:
+ FileBuilder plugin(String path)

参数:
+ String path - 文件路径

返回值:
+ FileBuilder - 返回对象本身方便链式调用

示例代码:
+ 通过 FileBuilder.plugin() 配置文件路径为项目插件路径
 */
// Files.buildFile() 用于构建一个 ScriptFile 对象
def scriptFile = $files.buildFile {
    // delegate -> FileBuilder
    // FileBuilder.plugin() 用于配置文件路径为项目插件路径
    plugin("apk/pluginapk.apk")
}
// Plugins.loadApk() 用于将apk作为插件加载
def plugin = $plugins.loadApk(1, scriptFile)
// DexPlugin.classLoader() 用于获取类加载器
def classLoader = plugin.classLoader()
// DexClassLoader.loadClass() 用于加载指定的类
def clazz = classLoader.loadClass("com.plugin.pluginapk.Test")
// 创建对象
def dex = clazz.newInstance()
// 调用Native(C/C++)方法
$console.log(dex.getNativeValue())
// 调用实例方法
$console.log(dex.getInstanceValue())
// 调用静态方法
$console.log(dex.getStaticValue())
// 调用静态Native(C/C++)方法
$console.log(dex.getStaticNativeValue())