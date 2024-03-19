package sample.云控.服务器端.AuthorizationCode

/*
功能:
+ 获取已经使用该授权码的设备id

定义:
+ String deviceId()

参数:
+ 无

返回值:
+ String - 使用该授权码的设备id,如果该授权码还没有设备使用,则返回null

示例代码:
+ 通过 AuthorizationCode.deviceId() 获取已经使用该授权码的设备id
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// CloudControlServer.authorizationCodes() 用于获取服务器授权码管理器
def authorizationCodes = $cloudControlServer.authorizationCodes()
// AuthorizationCodes.get() 用于获取指定分页的服务器授权码
authorizationCodes.get(1, 10).each {
    // AuthorizationCode.deviceId() 用于获取已经使用该授权码的设备id
    def deviceId = it.deviceId()
    $console.log(deviceId)
}