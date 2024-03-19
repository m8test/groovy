package sample.用户界面.Compose.组件.BackdropScaffold

/*
功能:
+ 设置后层隐藏时可见部分的高度.

定义:
+ BackdropScaffold peekHeight(Number height)

参数:
+ Number height - 需要设置的高度,单位dp

返回值:
+ BackdropScaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 BackdropScaffold.peekHeight() 方法设置后层隐藏时可见部分的高度.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.BackdropScaffold() 用于创建 BackdropScaffold 可组合项
    BackdropScaffold {
        // delegate -> BackdropScaffold
        // BackdropScaffold.peekHeight() 用于设置后层隐藏时可见部分的高度
        peekHeight(150)
    }
}
// Activity.onDestroy() 方法用于监听Activity销毁
$composeActivity.onDestroy {
    // Script.stop() 方法用于停止脚本
    $script.stop()
}
// Activity.start() 用于启动Android系统的Activity
$composeActivity.start()