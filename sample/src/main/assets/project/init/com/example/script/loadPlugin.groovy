package com.example.script

class PluginInitializer {
    static Object plugin
}

// ---------------加载dex插件开始----------------------

// Device.system() 用于获取System对象
def system = $device.system()
// System.supportedABIs() 用于获取设备所有支持的ABI
def abis = system.supportedABIs()
// Files.buildFile() 用于构建一个 ScriptFile 对象
def dexPath = $files.buildFile {
    // delegate -> FileBuilder
    // FileBuilder.plugin() 用于配置文件路径为项目插件路径
    plugin("dex/plugindex.dex")
}
// Files.buildFile() 用于构建一个 ScriptFile 对象
def soPath = $files.buildFile {
    // delegate -> FileBuilder
    // FileBuilder.plugin() 用于配置文件路径为项目插件路径
    plugin("so/${abis[0]}/")
}
// Plugins.loadDex() 用于将dex作为插件加载
PluginInitializer.plugin = $plugins.loadDex(1, dexPath, soPath)

// ---------------加载dex插件结束----------------------

// ---------------加载apk插件开始----------------------

//// Files.buildFile() 用于构建一个 ScriptFile 对象
//def scriptFile = $files.buildFile {
//    // delegate -> FileBuilder
//    // FileBuilder.plugin() 用于配置文件路径为项目插件路径
//    plugin("apk/pluginapk.apk")
//}
//// Plugins.loadApk() 用于将apk作为插件加载
//PluginInitializer.plugin = $plugins.loadApk(1, scriptFile)

// ---------------加载apk插件结束----------------------

// ---------------加载jar插件开始----------------------

//// Files.buildFile() 用于构建一个 ScriptFile 对象
//def scriptFile = $files.buildFile {
//    // delegate -> FileBuilder
//    // FileBuilder.plugin() 用于配置文件路径为项目插件路径
//    plugin("jar/pluginjar.jar")
//}
//// Plugins.loadJar() 用于将jar作为插件加载
//PluginInitializer.plugin = $plugins.loadJar(1, scriptFile)

// ---------------加载jar插件结束----------------------