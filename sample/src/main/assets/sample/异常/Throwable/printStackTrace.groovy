package sample.异常.Throwable

/*
功能:
+ 将此 Throwable 及其回溯打印到控制台.

定义:
+ Throwable printStackTrace()

参数:
+ 无

返回值:
+ Throwable - 返回对象本身,方便链式调用

示例代码:
+ 通过 Throwable.printStackTrack() 将此 Throwable 及其回溯打印到控制台.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    1 / 0
}.catchAll {
    // Throwable.printStackTrack() 用于将此 Throwable 及其回溯打印到控制台。
    it.printStackTrace()
}