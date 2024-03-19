package sample.线程.Timer

/*
功能:
+ 添加一个立即执行的定时任务.

定义:
+ int setImmediate(Closure closure, Object... params)

参数:
+ Closure closure - 需要执行的任务内容
    + 参数
        + Object... params Timer.setImmediate() 的第二个参数会传递到此处.
    + delegate - 无
+ Object... params - 执行定时任务所需要的参数,可以是任意类型任意多个参数,会作为参数直接传递到closure中.

返回值:
+ int - 定时任务的唯一标识(id),可以通过此值取消定时任务,也就是将其作为参数传递给 Timer.clearImmediate()

示例代码:
+ 获取主线程的定时器,并添加一个立即执行的定时任务.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// 获取定时器
def timer = mainThread.timer()
// 添加一个立即执行的定时任务
timer.setImmediate({ Object... params ->
    // 断言当前线程为主线程
    $assert.assertTrue($threads.currentThread() == $threads.mainThread(), "当前线程为主线程")
    // 打印参数
    params.each {
        $console.log(it)
    }
}, "参数1", "参数2", "参数3")