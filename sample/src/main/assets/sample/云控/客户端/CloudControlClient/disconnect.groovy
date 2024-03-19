package sample.云控.客户端.CloudControlClient

/*
功能:
+ 断开与指定服务器连接

定义:
+ CloudControlClient disconnect(String serverHost, int serverPort)

参数:
+ String serverHost - 服务器主机名
+ int serverPort - 服务器端口

返回值:
+ CloudControlClient - 返回对象本身方便链式调用

示例代码:
+ 通过 CloudControlClient.disconnect() 断开与指定服务器连接
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
    // CloudControlClient.disconnect() 用于断开与指定服务器连接
    $cloudControlClient.disconnect(serverHost, serverPort)
    $console.log("断开连接: $serverHost:$serverPort")
} else {
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(true)
    // CloudControlPeer.addOnConnectListener() 用于添加云控连接成功监听器
    $cloudControlClient.addOnConnectListener {
        // it -> CloudControlConnection
        $console.log("连接服务器成功")
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
