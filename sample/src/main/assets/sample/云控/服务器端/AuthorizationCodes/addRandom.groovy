package sample.云控.服务器端.AuthorizationCodes

/*
功能:
+ 随机添加指定数量以及长度服务器授权码

定义:
+ List<String> addRandom(int count, int length)

参数:
+ int count - 授权码的数量
+ int length - 授权码长度

返回值:
+ List<String> - 添加的授权码集合

示例代码:
+ 通过 AuthorizationCodes.addRandom() 随机添加指定数量以及长度服务器授权码
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.addRandom() 用于随机添加指定数量以及长度服务器授权码
$console.log(authorizationCodes.addRandom(1, 10))