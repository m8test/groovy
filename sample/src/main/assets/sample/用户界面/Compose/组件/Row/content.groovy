package sample.用户界面.Compose.组件.Row

/*
功能:
+ 设置 Row 内容.

定义:
+ Row content(Closure closure)

参数:
+ Closure closure - 设置内容的闭包
    + 参数 - 无
    + delegate - RowScopeSlot(RowScopeModifier)

返回值:
+ Row - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Row.content() 方法设置 Row 内容.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Row() 用于创建 Row 可组合项
    Row {
        // delegate -> Row
        // Row.content() 用于设置 Row 内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("Row")
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