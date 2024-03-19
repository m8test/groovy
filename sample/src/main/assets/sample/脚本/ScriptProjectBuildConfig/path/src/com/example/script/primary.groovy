package com.example.script


/*
功能:
+ 设置已构建的脚本工程路径

定义:
+ ScriptProjectBuildConfig path(ScriptFile path)

参数:
+ ScriptFile path - 待启动的已构建的脚本工程路径

返回值:
+ ScriptProjectBuildConfig - 返回对象本身方便链式调用

示例代码:
+ 通过 ScriptProjectBuildConfig.path() 方法设置已构建的脚本工程路径
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// ScriptEngine.startScriptProjectBuild() 用于启动已构建的脚本工程
$scriptEngine.startScriptProjectBuild {
    // delegate -> ScriptProjectBuildConfig
    // Files.buildFile() 用于构建一个 ScriptFile 对象
    def scriptFile = $files.buildFile {
        // delegate -> FileBuilder
        // FileBuilder.res() 用于配置文件路径为项目资源文件路径
        res("com.example.app")
    }
    // ScriptProjectBuildConfig.path() 用于设置已构建的脚本工程路径
    path(scriptFile)
}