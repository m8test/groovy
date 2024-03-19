package sample.控制台.Console

/*
功能:
+ 停止一个通过 Console.time() 启动的计时器.

定义:
+ long timeEnd(String timerName)

参数:
+ String timerName - 需要停止的计时器名字.一旦停止,计时器所经过的时间会被自动输出到控制台.

返回值:
+ long - 计时器耗时,单位毫秒,如果计时器不存在则返回-1

示例代码
+ 通过 Console.time() 和 Console.timerEnd() 输出代码执行时间到控制台.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
def label = "label"
// 开启一个计时器
$console.time(label)
// 模拟耗时操作
for (i in 0..<10) {
    $threads.sleep(100)
}
// 结束计时器
$console.timeEnd(label)