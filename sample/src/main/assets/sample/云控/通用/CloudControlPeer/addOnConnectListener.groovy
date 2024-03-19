package sample.云控.通用.CloudControlPeer

/*
功能:
+ 添加云控连接成功监听器

定义:
+ int addOnConnectListener(Closure closure)

参数:
+ Closure closure - 设置监听器的闭包
    + 参数
        + CloudControlConnection - 接收到数据的连接
    + delegate - 无

返回值:
+ int - 监听器id, CloudControlServer.removeOnConnectListener() 取消监听器时传递的参数

示例代码:
+ 通过 CloudControlPeer.addOnConnectListener() 添加云控连接成功监听器
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