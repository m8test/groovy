package sample.云控.服务器端.AuthorizationCodes

/*
功能:
+ 获取指定分页的服务器授权码

定义:
+ List<AuthorizationCode> get(int page, int size)

参数:
+ int page - 分页页数
+ int size - 页数大小

返回值:
+ List<AuthorizationCode> - 授权码集合

示例代码:
+ 通过 AuthorizationCodes.get() 获取指定分页的服务器授权码
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.get() 用于获取指定分页的服务器授权码
$console.log(authorizationCodes.get(1, 10))