package com.example.script


/*
功能:
+ 设置脚本文件路径

定义:
+ ScriptFileConfig file(ScriptFile file)

参数:
+ ScriptFile file - 需要启动的脚本文件

返回值:
+ ScriptFileConfig - 返回对象本身方便链式调用

示例代码:
+ 通过 ScriptFileConfig.file() 方法设置脚本文件路径
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