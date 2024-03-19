package sample.云控.通用.CloudControlPeer

/*
功能:
+ 添加接收文本数据监听器

定义:
+ int addOnTextListener(Closure closure)

参数:
+ Closure closure - 设置监听器的闭包
    + 参数
        + CloudControlConnection - 接收到数据的连接
        + String data - 接收到的文本数据
    + delegate - 无

返回值:
+ int - 监听器id, CloudControlServer.removeOnTextListener() 取消监听器时传递的参数

示例代码:
+ 通过 CloudControlPeer.addOnTextListener() 添加接收文本数据监听器
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