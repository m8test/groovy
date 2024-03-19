package sample.用户界面.Compose.组件.ExtendedFloatingActionButton

/*
功能:
+ 设置扩展悬浮按钮文本.

定义:
+ ExtendedFloatingActionButton text(Closure closure)

参数:
+ Closure closure - 设置文本的闭包
    + 参数 - 无
    + delegate - Slot(Modifier)

返回值:
+ ExtendedFloatingActionButton - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 ExtendedFloatingActionButton.text() 方法设置扩展悬浮按钮文本.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.ExtendedFloatingActionButton() 用于创建 ExtendedFloatingActionButton 可组合项
    ExtendedFloatingActionButton {
        // delegate -> ExtendedFloatingActionButton
        // ExtendedFloatingActionButton.text() 用于设置扩展悬浮按钮文本
        text {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("添加")
            }
        }
    }
}
// Activity.onDestroy() 方法用于监听Activity销毁
$composeActivity.onDestroy {
    // Script.stop() 方法用于停止脚本
    $script.stop()
}
// Activity.start() 用于启动Android系统的Activity
$composeActivity.start()