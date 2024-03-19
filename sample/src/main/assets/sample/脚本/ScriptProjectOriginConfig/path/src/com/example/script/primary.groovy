package com.example.script



/*
功能:
+ 设置原始脚本工程路径

定义:
+ ScriptProjectOriginConfig path(ScriptFile path)

参数:
+ ScriptFile path - 待启动的原始脚本工程路径

返回值:
+ ScriptProjectOriginConfig - 返回对象本身方便链式调用

示例代码:
+ 通过 ScriptProjectOriginConfig.path() 方法设置原始脚本工程路径
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// ScriptEngine.startScriptProjectOrigin() 用于启动原始脚本工程
$scriptEngine.startScriptProjectOrigin {
    // delegate -> ScriptProjectOriginConfig
    // Files.buildFile() 用于构建一个 ScriptFile 对象
    def scriptFile = $files.buildFile {
        // delegate -> FileBuilder
        // FileBuilder.res() 用于配置文件路径为项目资源文件路径
        res("com.example.app")
    }
    // ScriptProjectOriginConfig.path() 用于设置原始脚本工程路径
    path(scriptFile)
}