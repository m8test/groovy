package sample.云控.客户端.CloudControlClientConnection

/*
功能:
+ 获取当前服务器连接信息

定义:
+ ConnectionInfo connectionInfo()

参数:
+ 无

返回值:
+ ConnectionInfo - 当前服务器连接信息

示例代码:
+ 通过 CloudControlClientConnection.connectionInfo() 获取当前服务器连接信息
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
def serverHost = "192.168.1.101"
def serverPort = 8082
// 获取主线程
def mainThread = $threads.mainThread()
// CloudControlClient.isConnected() 用于判断是否已经连接到指定的服务器
def isConnected = $cloudControlClient.isConnected(serverHost, serverPort)
if (isConnected) {
    $console.log("已经连接到服务器 $serverHost:$serverPort")
} else {
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(true)
    // CloudControlPeer.addOnConnectListener() 用于添加云控连接成功监听器
    $cloudControlClient.addOnConnectListener {
        // it -> CloudControlConnection
        $console.log("连接服务器成功")
        // CloudControlClientConnection.connectionInfo() 用于获取当前服务器连接信息
        def info = it.connectionInfo()
        // ConnectionInfo.host() 用于获取服务器主机名
        $console.log("服务器主机名:" + info.host())
        // ConnectionInfo.port() 用于获取服务器端口
        $console.log("服务器端口:" + info.port())
        // ScriptThread.background() 用于设置线程是否后台运行
        mainThread.background(false)
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
