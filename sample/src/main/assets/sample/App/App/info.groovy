package sample.App.App

/*
功能:
+ 获取 App 信息

定义:
+ AppInfo info(String packageName)

参数:
+ String packageName - app 包名

返回值:
+ AppInfo - App 信息

示例代码:
+ 通过 App.info() 获取 App 信息
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// App.info() 用于获取 App 信息
def appInfo = $app.info("com.m8test.main")
$console.log(appInfo)