package sample.云控.通用.CloudControlConnection

/*
功能:
+ 发送文本数据

定义:
+ CloudControlConnection sendText(String data)

参数:
+ String data - 需要发送的文本数据

返回值:
+ CloudControlConnection - 返回对象本身方便链式调用

示例代码:
+ 通过 CloudControlConnection.sendText() 发送文本数据
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
def serverHost = "192.168.1.101"
def serverPort = 8082
// 获取主线程
def mainThread = $threads.mainThread()
// CloudControlClient.isConnected() 用于判断是否已经连接到指定的服务器
def isConnected = $cloudControlClient.isConnected(serverHost, serverPort)
// CloudControlPeer.addOnTextListener() 用于添加接收文本数据监听器
$cloudControlClient.addOnTextListener { connection, data ->
    $console.log(data)
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}
if (isConnected) {
    $console.log("已经连接到服务器 $serverHost:$serverPort")
} else {
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(true)
    // CloudControlPeer.addOnConnectListener() 用于添加云控连接成功监听器
    $cloudControlClient.addOnConnectListener {
        // it -> CloudControlConnection
        $console.log("连接服务器成功")
        // CloudControlConnection.sendText() 用于发送文本数据
        it.sendText("text")
    }
    // CloudControlClient.connect() 用于连接云控服务器
    $cloudControlClient.connect {
        // delegate -> ConnectionInfo
        // ConnectionInfo.host() 用于设置服务器主机名
        host(serverHost)
        // ConnectionInfo.port() 用于设置服务器端口
        port(serverPort)
    }
}
