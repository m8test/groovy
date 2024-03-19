package sample.云控.服务器端.CloudControlServer

/*
功能:
+ 添加云控服务器启动监听器

定义:
+ int addOnStartListener(Closure closure)

参数:
+ Closure closure - 设置监听器的闭包
    + 参数 - 无
    + delegate - 无

返回值:
+ int - 监听器id, CloudControlServer.removeOnStartListener() 取消监听器时传递的参数

示例代码:
+ 通过 CloudControlServer.addOnStartListener() 添加云控服务器启动监听器
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// CloudControlServer.port() 用于获取云控服务器启动的端口号
def serverPort = $cloudControlServer.port()
if (serverPort != -1) {
    $console.log("服务器已启动: $serverPort")
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