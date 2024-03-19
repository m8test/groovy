package sample.时间日期.ScriptDateTime

/*
功能:
+ 获取日期中的时

定义:
+ int hour()

参数:
+ 无

返回值:
+ int - 日期中的时

示例代码:
+ 通过 ScriptDateTime.hour() 获取日期中的时.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// DateTimes.create() 用于创建ScriptDateTime对象
def d = $dateTimes.create($dateTimes.timestamp())
// ScriptDateTime.hour() 用于获取日期中的时
$console.log(d.hour())