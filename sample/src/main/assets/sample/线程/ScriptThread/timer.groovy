package sample.线程.ScriptThread

/*
功能:
+ 获取线程对应的定时器.只有通过 Threads.startThread() 启动的线程以及脚本主线程(不是安卓主线程)才会有定时器,如果是其他线程调用此方法返回结果为空

定义:
+ Timer timer()

参数:
+ 无

返回值:
+ Timer - 线程对应的定时器.

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
    // 打印参数
    params.each {
        $console.log(it)
    }
}, "参数1", "参数2", "参数3")