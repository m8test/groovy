package sample.云控.通用.CloudControlPeer

/*
功能:
+ 获取所有已经建立的连接

定义:
+ List<CloudControlConnection> connections()

参数:
+ 无

返回值:
+ List<CloudControlConnection> - 所有已经建立的连接

示例代码:
+ 通过 CloudControlPeer.connections() 获取所有已经建立的连接
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlPeer.connections() 用于获取所有已经建立的连接
$cloudControlClient.connections().each {
    // CloudControlConnection.disconnect() 用于断开域控连接
    it.disconnect()
}
