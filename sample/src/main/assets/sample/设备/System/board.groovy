package sample.设备.System

/*
功能:
+ 获取设备主板型号,例如"goldfish"

定义:
+ String board()

参数:
+ 无

返回值:
+ String - 设备主板型号

示例代码:
+ 通过 System.board() 获取设备主板型号.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.system() 用于获取System对象
def system = $device.system()
// System.board() 用于获取设备主板型号
def board = system.board()
$console.log(board)