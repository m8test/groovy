package sample.设备.Vibrator

/*
功能:
+ 震动设备

定义:
+ Vibrator vibrate(long time)

参数:
+ long time - 震动时间,单位毫秒

返回值:
+ Vibrator - 返回对象本身方便链式调用

示例代码:
+ 通过 Vibrator.vibrate() 震动设备
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.vibrator() 用于获取Vibrator对象
def vibrator = $device.vibrator()
// Vibrator.vibrate() 用于震动设备
vibrator.vibrate(1000)