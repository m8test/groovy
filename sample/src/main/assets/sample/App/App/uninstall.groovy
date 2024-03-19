package sample.App.App

/*
功能:
+ 跳转到卸载 App 界面

定义:
+ App uninstall(String packageName)

参数:
+ String packageName - app 包名

返回值:
+ App - 返回对象本身方便链式调用

示例代码:
+ 通过 App.uninstall() 跳转到卸载 App 界面
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// App.uninstall() 用于跳转到卸载 App 界面
$app.uninstall("com.m8test.main")