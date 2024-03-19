package sample.线程.Threads

/*
功能:
+ 获取脚本的线程,也就是执行 Threads.currentThread() 所在的线程.

定义:
+ ScriptThread currentThread()

参数:
+ 无

返回值:
+ ScriptThread - 当前线程对象.

示例代码:
+ 获取当前线程并打印线程名到控制台.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取当前线程
def currentThread = $threads.currentThread()
// 控制台输出脚本当前线程名
$console.log(currentThread.name())
// 断言当前线程为主线程
$assert.assertTrue(currentThread == $threads.mainThread(), "当前线程为主线程")