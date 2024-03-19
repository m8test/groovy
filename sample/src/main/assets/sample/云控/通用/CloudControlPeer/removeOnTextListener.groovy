package sample.云控.通用.CloudControlPeer

/*
功能:
+ 移除接收文本数据监听器

定义:
+ boolean removeOnTextListener(int listenerId)

参数:
+ int listenerId - 监听器id

返回值:
+ boolean - listenerId对应的监听器存在并且移除成功时返回true,否则返回false

示例代码:
+ 通过 CloudControlPeer.removeOnTextListener() 移除接收文本数据监听器
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// ScriptThread.background() 用于设置线程是否后台运行
mainThread.background(true)
// CloudControlPeer.addOnTextListener() 用于添加接收文本数据监听器
$cloudControlServer.addOnTextListener { connection, data ->
    $console.log(data)
    // CloudControlConnection.sendText() 用于发送文本数据
    connection.sendText("text")
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}
// CloudControlPeer.addOnTextListener() 用于添加接收文本数据监听器
def listenerId = $cloudControlServer.addOnTextListener { connection, data ->
    $console.log(data)
    // CloudControlConnection.sendText() 用于发送文本数据
    connection.sendText("text")
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}
// CloudControlPeer.removeOnTextListener() 用于移除接收文本数据监听器
$console.log($cloudControlServer.removeOnTextListener(listenerId))
// CloudControlServer.port() 用于获取云控服务器启动的端口号
def serverPort = $cloudControlServer.port()
if (serverPort != -1) {
    $console.log("服务器已启动: $serverPort")
} else {
    // CloudControlServer.addOnStartListener() 用于添加云控服务器启动监听器
    $cloudControlServer.addOnStartListener {
        // CloudControlServer.port() 用于获取云控服务器启动的端口号
        serverPort = $cloudControlServer.port()
        $console.log("启动服务器成功 $serverPort")
    }
    // CloudControlServer.start() 用于启动云控服务器
    $cloudControlServer.start(8082, false)
}