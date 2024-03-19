package com.example.script


/*
功能:
+ 启动脚本文件

定义:
+ Script startScriptFile(Closure closure)

参数:
+ Closure closure - 设置脚本配置的闭包
    + 参数 - 无
    + delegate - ScriptFileConfig

返回值:
+ Script - 返回启动的脚本对象,如果启动脚本失败则返回null

示例代码:
+ 通过 ScriptEngine.startScriptFile() 方法启动脚本文件
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// ScriptEngine.startScriptFile() 用于启动脚本文件
$scriptEngine.startScriptFile {
    // delegate -> ScriptFileConfig
    // Files.buildFile() 用于构建一个 ScriptFile 对象
    def scriptFile = $files.buildFile {
        // delegate -> FileBuilder
        // FileBuilder.res() 用于配置文件路径为项目资源文件路径
        res("scriptFile.groovy")
    }
    // ScriptFileConfig.file() 用于设置脚本文件路径
    file(scriptFile)
}