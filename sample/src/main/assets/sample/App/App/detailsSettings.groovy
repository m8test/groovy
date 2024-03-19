package sample.App.App

/*
功能:
+ 跳转到 App 设置页面

定义:
+ App detailsSettings(String packageName)

参数:
+ String packageName - app 包名

返回值:
+ App - 返回对象本身方便链式调用

示例代码:
+ 通过 App.detailsSettings() 跳转到 App 设置页面
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// App.detailsSettings() 用于跳转到 App 设置页面
$app.detailsSettings("com.m8test.main")