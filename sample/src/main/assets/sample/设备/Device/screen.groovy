package sample.设备.Device

/*
功能:
+ 获取Screen对象.

定义:
+ Screen screen()

参数:
+ 无

返回值:
+ Screen - Screen对象

示例代码:
+ 通过 Device.screen() 获取Screen对象并判断设备是否亮屏
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.screen() 用于获取Screen对象
def screen = $device.screen()
// Screen.isScreenOn() 用于判断当前设备是否亮屏
def isScreenOn = screen.isScreenOn()
$console.log(isScreenOn)