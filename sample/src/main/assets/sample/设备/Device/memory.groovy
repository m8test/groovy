package sample.设备.Device

/*
功能:
+ 获取Memory对象.

定义:
+ Memory memory()

参数:
+ 无

返回值:
+ Memory - Memory对象

示例代码:
+ 通过 Device.memory() 获取Memory对象并获取当前可用内存
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.memory() 用于获取Memory对象
def memory = $device.memory()
// Memory.available() 用于获取当前可用内存
def available = memory.available()
$console.log(available)