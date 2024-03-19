package sample.设备.Memory

/*
功能:
+ 获取设备总内存.

定义:
+ long total()

参数:
+ 无

返回值:
+ long - 设备总内存

示例代码:
+ 通过 Memory.total() 获取设备总内存.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.memory() 用于获取Memory对象
def memory = $device.memory()
// Memory.total() 用于获取设备总内存
def total = memory.total()
$console.log(total)