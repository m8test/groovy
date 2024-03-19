package sample.云控.服务器端.AuthorizationCode

/*
功能:
+ 获取授权码字符串

定义:
+ String code()

参数:
+ 无

返回值:
+ String - 授权码字符串

示例代码:
+ 通过 AuthorizationCode.code() 获取授权码字符串
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.get() 用于获取指定分页的服务器授权码
authorizationCodes.get(1, 10).each {
    // AuthorizationCode.code() 用于获取授权码字符串
    def code = it.code()
    $console.log(code)
}