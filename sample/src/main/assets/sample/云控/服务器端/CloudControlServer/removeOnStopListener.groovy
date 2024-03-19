package sample.云控.服务器端.CloudControlServer

/*
功能:
+ 移除云控服务器停止监听器

定义:
+ boolean removeOnStopListener(int listenerId)

参数:
+ int listenerId - 监听器id

返回值:
+ boolean - listenerId对应的监听器存在并且移除成功时返回true,否则返回false

示例代码:
+ 通过 CloudControlServer.removeOnStopListener() 移除云控服务器停止监听器
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// CloudControlServer.port() 用于获取云控服务器启动的端口号
def serverPort = $cloudControlServer.port()
if (serverPort != -1) {
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(true)
    // CloudControlServer.addOnStopListener() 用于添加云控服务器停止监听器
    def listenerId = $cloudControlServer.addOnStopListener {
        $console.log("被移除的监听器,不会被打印")
        // ScriptThread.background() 用于设置线程是否后台运行
        mainThread.background(false)
    }
    $cloudControlServer.addOnStopListener {
        $console.log("停止服务器成功")
        // ScriptThread.background() 用于设置线程是否后台运行
        mainThread.background(false)
    }
    // CloudControlServer.removeOnStopListener() 用于移除云控服务器停止监听器
    $cloudControlServer.removeOnStopListener(listenerId)
    // CloudControlServer.stop() 用于停止云控服务器
    $cloudControlServer.stop()
} else {
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(true)
    // CloudControlServer.addOnStartListener() 用于添加云控服务器启动监听器
    $cloudControlServer.addOnStartListener {
        // CloudControlServer.port() 用于获取云控服务器启动的端口号
        serverPort = $cloudControlServer.port()
        $console.log("启动服务器成功 $serverPort")
        // ScriptThread.background() 用于设置线程是否后台运行
        mainThread.background(false)
    }
    // CloudControlServer.start() 用于启动云控服务器
    $cloudControlServer.start(8082, false)
}