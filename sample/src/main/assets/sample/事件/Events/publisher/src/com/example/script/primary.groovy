package com.example.script


/*
功能:
+ 获取事件发布器

定义:
+ Publisher publisher()

参数:
+ 无

返回值:
+ Publisher - 事件发布器

示例代码:
+ 通过 Events.publisher() 方法获取事件发布器
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
// Threads.mainThread() 用于获取脚本主线程
def mainThread = $threads.mainThread()
// ScriptThread.timer() 用于获取线程对应的定时器
def timer = mainThread.timer()
// Timer.setTimeout() 用于添加一个延时执行的定时任务
timer.setTimeout({
    // Events.publisher() 用于获取事件发布器
    def publisher = $events.publisher()
    // Publisher.publishLocal() 用于发布本地事件
    publisher.publishLocal({
        // delegate -> LocalSubscription
        // LocalSubscription.channel() 用于设置本地订阅的频道
        channel("subscription channel")
        // LocalSubscription.id() 用于设置本地订阅的id
        id("subscription id")
    }) {
        // delegate -> Event
        // Event.data() 用于设置事件中包含的数据
        data("data from event")
    }
}, 3000)
