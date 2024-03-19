package sample.时间日期.ScriptDateTime

/*
功能:
+ 获取日期中的毫秒

定义:
+ int millis()

参数:
+ 无

返回值:
+ int - 日期中的毫秒

示例代码:
+ 通过 ScriptDateTime.millis() 获取日期中的毫秒.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// DateTimes.create() 用于创建ScriptDateTime对象
def d = $dateTimes.create($dateTimes.timestamp())
// ScriptDateTime.millis() 用于获取日期中的毫秒
$console.log(d.millis())