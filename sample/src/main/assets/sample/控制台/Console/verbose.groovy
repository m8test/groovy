package sample.控制台.Console

/*
功能:
+ 向控制台输出一条verbose等级消息.

定义:
+ Console verbose(Object data, Object... options)

参数:
+ Object data - 需要输出到控制台的数据
+ Object... options - 额外需要输出到控制台的数据

返回值:
+ Console - 返回调用对象本身,方便链式调用.

实例代码:
+ 向控制台输出一条verbose等级消息.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 输出等级为verbose的信息
$console.verbose("verbose")