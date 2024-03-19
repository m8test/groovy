package sample.云控.服务器端.AuthorizationCodes

/*
功能:
+ 移除服务器授权码

定义:
+ boolean remove(String code)

参数:
+ String code - 需要移除的授权码

返回值:
+ boolean - 移除成功返回true,否则返回false(授权码不存在)

示例代码:
+ 通过 AuthorizationCodes.remove() 移除服务器授权码
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.remove() 用于移除服务器授权码
$console.log(authorizationCodes.remove("1234567890"))