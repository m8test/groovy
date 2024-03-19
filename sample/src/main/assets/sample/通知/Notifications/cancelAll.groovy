package sample.通知.Notifications

/*
功能:
+ 取消所有通知.

定义:
+ Notifications cancelAll()

参数:
+ 无

返回值:
+ Notifications - 返回对象本身方便链式调用

示例代码:
+ 通过 Notifications.cancelAll() 取消所有通知
 */
// Notifications.createNotification() 用于创建通知
def notification = $notifications.createNotification {
    // delegate -> Notification
    // Notification.contentText() 用于设置通知内容文字
    contentText("通知内容文字")
    // Notification.contentTitle() 用于设置通知内容标题
    contentTitle("通知内容标题")
}
// Notifications.notify() 用于发送通知
$notifications.notify("tag", 1, notification)
// Notifications.notify() 用于发送通知
$notifications.notify("tag", 2, notification)
// Notifications.notify() 用于发送通知
$notifications.notify("tag", 3, notification)
// Threads.mainThread() 用于获取脚本主线程
def mainThread = $threads.mainThread()
// ScriptThread.timer() 用于获取线程对应的定时器
def timer = mainThread.timer()
// Timer.setTimeout() 用于添加一个延时执行的定时任务
timer.setTimeout({
    // Notifications.cancelAll() 用于取消所有通知
    $notifications.cancelAll()
}, 10000)