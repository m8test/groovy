package sample.设备.Screen

/*
功能:
+ 取消设备保持唤醒状态。用于取消 Screen.keepScreenOn(), Screen.keepScreenDim() 等函数设置的屏幕常亮。

定义:
+ Screen cancelKeepingAwake()

参数:
+ 无

返回值:
+ Screen - 返回对象本身方便链式调用

示例代码:
+ 通过 Screen.cancelKeepingAwake() 取消设备保持唤醒状态.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Device.screen() 用于获取Screen对象
def screen = $device.screen()
// Screen.keepScreenOn() 用于保持屏幕常亮
screen.keepScreenOn()
// Screen.cancelKeepingAwake() 用于取消设备保持唤醒状态
screen.cancelKeepingAwake()