package sample.通知.Notification

/*
功能:
+ 设置通知内容文字

定义:
+ Notification contentText(String text)

参数:
+ String text - 通知文字

返回值:
+ Notification - 返回对象本身方便链式调用

示例代码:
+ 通过 Notification.contentText() 设置通知内容文字
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