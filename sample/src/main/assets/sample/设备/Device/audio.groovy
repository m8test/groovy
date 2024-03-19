package sample.设备.Device

/*
功能:
+ 获取Audio对象.

定义:
+ Audio audio()

参数:
+ 无

返回值:
+ Audio - Audio对象

示例代码:
+ 通过 Device.audio() 获取Audio对象并获取闹钟最大音量.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.audio() 用于获取Audio对象
def audio = $device.audio()
// Audio.alarmMaxVolume() 用于获取闹钟最大音量
def alarmMaxVolume = audio.alarmMaxVolume()
$console.log(alarmMaxVolume)