package sample.云控.服务器端.CloudControlServer

/*
功能:
+ 获取云控服务器启动的端口号

定义:
+ int port()

参数:
+ 无

返回值:
+ int - 云控服务器启动的端口号,如果服务器未启动则返回-1

示例代码:
+ 通过 CloudControlServer.port() 获取云控服务器启动的端口号
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
    $cloudControlServer.addOnStopListener {
        $console.log("停止服务器成功")
        // ScriptThread.background() 用于设置线程是否后台运行
        mainThread.background(false)
    }
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