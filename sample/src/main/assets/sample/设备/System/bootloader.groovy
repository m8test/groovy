package sample.设备.System

/*
功能:
+ 系统引导加载程序版本号

定义:
+ String bootloader()

参数:
+ 无

返回值:
+ String - 系统引导加载程序版本号

示例代码:
+ 通过 System.bootloader() 获取系统引导加载程序版本号.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.system() 用于获取System对象
def system = $device.system()
// System.bootloader() 用于获取系统引导加载程序版本号
def bootloader = system.bootloader()
$console.log(bootloader)