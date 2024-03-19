package sample.设备.Device

/*
功能:
+ 获取System对象.

定义:
+ System system()

参数:
+ 无

返回值:
+ System - System对象

示例代码:
+ 通过 Device.system() 获取System对象并获取设备品牌
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.system() 用于获取System对象
def system = $device.system()
// System.brand() 用于获取设备品牌
def brand = system.brand()
$console.log(brand)