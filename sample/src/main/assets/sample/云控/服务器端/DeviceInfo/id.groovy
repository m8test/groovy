package sample.云控.服务器端.DeviceInfo

/*
功能:
+ 获取设备id

定义:
+ String id()

参数:
+ 无

返回值:
+ String - 设备id

示例代码:
+ 通过 DeviceInfo.id() 获取设备id
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// ScriptThread.background() 用于设置线程是否后台运行
mainThread.background(true)
// CloudControlServer.port() 用于获取云控服务器启动的端口号
def serverPort = $cloudControlServer.port()
if (serverPort == -1) {
    // CloudControlServer.addOnStartListener() 用于添加云控服务器启动监听器
    $cloudControlServer.addOnStartListener {
        // CloudControlServer.port() 用于获取云控服务器启动的端口号
        serverPort = $cloudControlServer.port()
        $console.log("启动服务器成功 $serverPort")
    }
    // CloudControlServer.start() 用于启动云控服务器
    $cloudControlServer.start(8082, false)
}
// CloudControlPeer.addOnConnectListener() 用于添加云控连接成功监听器
$cloudControlServer.addOnConnectListener {
    // it -> CloudControlConnection
    $console.log("设备连接成功")
    // CloudControlServerConnection.deviceInfo() 用于获取设备信息
    def deviceInfo = it.deviceInfo()
    // DeviceInfo.id() 用于获取设备id
    $console.log(deviceInfo.id())
    // ScriptThread.background() 用于设置线程是否后台运行
    mainThread.background(false)
}