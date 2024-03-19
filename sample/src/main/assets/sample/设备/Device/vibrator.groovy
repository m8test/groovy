package sample.设备.Device

/*
功能:
+ 获取Vibrator对象.

定义:
+ Vibrator vibrator()

参数:
+ 无

返回值:
+ Vibrator - Vibrator对象

示例代码:
+ 通过 Device.vibrator() 获取Vibrator对象并震动设备
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.vibrator() 用于获取Vibrator对象
def vibrator = $device.vibrator()
// Vibrator.vibrate() 用于震动设备
vibrator.vibrate(1000)