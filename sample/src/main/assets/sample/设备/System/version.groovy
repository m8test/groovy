package sample.设备.System

/*
功能:
+ 获取Version对象

定义:
+ Version version()

参数:
+ 无

返回值:
+ Version - Version对象

示例代码:
+ 通过 System.version() 获取Version对象并通过该对象获取安卓SDK版本.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.system() 用于获取System对象
def system = $device.system()
// System.version() 用于获取Version对象
def version = system.version()
// Version.sdkInt() 用于获取此硬件设备上当前运行的软件的SDK版本
def sdkInt = version.sdkInt()
$console.log(sdkInt)