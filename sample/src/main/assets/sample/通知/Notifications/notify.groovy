package sample.通知.Notifications

/*
功能:
+ 发送通知,需要发送通知的权限

定义:
+ Notifications notify(String tag, int id, Notification notification)

参数:
+ String tag - 通知的标签,可以为null
+ int id - 通知的id
+ Notification notification - 需要发送的通知

返回值:
+ Notifications - 返回对象本身方便链式调用

示例代码:
+ 通过 Notifications.notify() 发送通知
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