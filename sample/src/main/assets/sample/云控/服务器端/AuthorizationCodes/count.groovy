package sample.云控.服务器端.AuthorizationCodes

/*
功能:
+ 获取服务器授权码的数量

定义:
+ int count()

参数:
+ 无

返回值:
+ int - 服务器授权码的数量

示例代码:
+ 通过 AuthorizationCodes.count() 获取服务器授权码的数量
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.count() 用于获取服务器授权码的数量
$console.log(authorizationCodes.count())