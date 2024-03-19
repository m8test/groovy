package sample.通知.Notification

/*
功能:
+ 设置通知大图标

定义:
+ Notification largeIcon(ScriptImage image)

参数:
+ ScriptImage image - 需要设置的图标

返回值:
+ Notification - 返回对象本身方便链式调用

示例代码:
+ 通过 Notification.largeIcon() 设置通知大图标
 */
// Notifications.createNotification() 用于创建通知
def notification = $notifications.createNotification {
    // delegate -> Notification
    // Notification.contentText() 用于设置通知内容文字
    contentText("通知内容文字")
    // Notification.contentTitle() 用于设置通知内容标题
    contentTitle("通知内容标题")
    // Images.read() 用于读取图片
    def scriptImage = $images.read {
        // delegate -> ImageReader
        // ImageReader.url() 用于从网络读取图片
        url("https://s1.ax1x.com/2023/02/17/pSbOeMj.jpg")
    }
    // Notification.largeIcon() 用于设置通知大图标
    largeIcon(scriptImage)
}
// Notifications.notify() 用于发送通知
$notifications.notify("tag", 1, notification)