package sample.时间日期.DateTimes

/*
功能:
+ 获取当前时间戳.

定义:
+ long timestamp()

参数:
+ 无

返回值:
+ long - 当前时间戳.

示例代码:
+ 通过 DateTimes.timestamp() 获取当前时间戳.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// DateTimes.timestamp() 用于获取当前时间戳
def timestamp = $dateTimes.timestamp()
$console.log(timestamp)