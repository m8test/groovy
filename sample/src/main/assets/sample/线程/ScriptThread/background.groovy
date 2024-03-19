package sample.线程.ScriptThread

/*
功能:
+ 设置线程是否后台运行,一般适用于网络连接相关的api,例如 WebSocket 客户端,需要设置线程后台运行防止脚本自动停止

定义:
+ ScriptThread background(boolean isBackground)

参数:
+ boolean isBackground - true表示开启线程后台运行,法拉瑟表示关闭线程后台运行

返回值:
+ ScriptThread - 返回对象本身方便链式调用

示例代码:
+ 通过 ScriptThread.background() 方法设置线程是否后台运行
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 获取主线程
def mainThread = $threads.mainThread()
// ScriptThread.background() 用于设置线程是否后台运行
mainThread.background(true)
// 取消后台运行
// mainThread.background(false)