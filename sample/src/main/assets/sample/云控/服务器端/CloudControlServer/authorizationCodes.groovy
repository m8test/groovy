package sample.云控.服务器端.CloudControlServer

/*
功能:
+ 获取服务器授权码管理器

定义:
+ AuthorizationCodes authorizationCodes()

参数:
+ 无

返回值:
+ AuthorizationCodes - 服务器授权码管理器

示例代码:
+ 通过 CloudControlServer.authorizationCodes() 获取服务器授权码管理器
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.add() 用于添加服务器授权码
$console.log(authorizationCodes.add("1234567890"))