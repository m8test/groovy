package sample.云控.通用.CloudControlPeer

/*
功能:
+ 移除云控连接断开监听器

定义:
+ boolean removeOnDisconnectListener(int listenerId)

参数:
+ int listenerId - 监听器id

返回值:
+ boolean - listenerId对应的监听器存在并且移除成功时返回true,否则返回false

示例代码:
+ 通过 CloudControlPeer.removeOnDisconnectListener() 移除云控连接断开监听器
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
def serverHost = "192.168.1.101"
def serverPort = 8082
// 获取主线程
def mainThread = $threads.mainThread()
// ScriptThread.background() 用于设置线程是否后台运行
mainThread.background(true)
// CloudControlPeer.addOnDisconnectListener() 用于添加云控连接断开监听器
$cloudControlClient.addOnDisconnectListener {
    // it -> CloudControlConnection
    $console.log("断开连接:来自监听器")
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}
// CloudControlPeer.addOnDisconnectListener() 用于添加云控连接断开监听器
def listenerId = $cloudControlClient.addOnDisconnectListener {
    // it -> CloudControlConnection
    $console.log("被移除的监听器,不会执行")
    $console.log("断开连接:来自监听器")
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}
// CloudControlPeer.removeOnDisconnectListener() 用于移除云控连接断开监听器
$console.log($cloudControlClient.removeOnDisconnectListener(listenerId))
// CloudControlClient.isConnected() 用于判断是否已经连接到指定的服务器
def isConnected = $cloudControlClient.isConnected(serverHost, serverPort)
if (isConnected) {
    // CloudControlClient.disconnect() 用于断开与指定服务器连接
    $cloudControlClient.disconnect(serverHost, serverPort)
    $console.log("断开连接: $serverHost:$serverPort")
} else {
    // CloudControlPeer.addOnConnectListener() 用于添加云控连接成功监听器
    $cloudControlClient.addOnConnectListener {
        // it -> CloudControlConnection
        $console.log("连接服务器成功")
        // CloudControlConnection.disconnect() 用于断开域控连接
        it.disconnect()
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