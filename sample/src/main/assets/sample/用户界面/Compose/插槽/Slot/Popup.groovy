package sample.用户界面.Compose.插槽.Slot

/*
功能:
+ 创建 Popup 可组合项

定义:
+ Slot Popup(Closure closure)

参数:
+ Closure closure - 设置 Popup 的闭包
    + 参数 - 无
    + delegate - Popup

返回值:
+ Slot - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Slot.Popup() 方法创建 Popup 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(false)
    // Slot.TextButton() 用于设置文本按钮
    TextButton {
        // delegate -> TextButton
        // TextButton.content() 用于设置按钮内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("显示弹出窗口")
            }
        }
        // TextButton.onClick() 用于处理点击事件
        onClick {
            // 设置状态
            state.value(true)
        }
    }
    // Slot.Popup() 用于创建 Popup 可组合项
    Popup {
        // delegate -> Popup
        // Popup.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // Popup.onDismissRequest() 用于设置弹出窗口取消时监听事件
        onDismissRequest {
            // 隐藏弹出窗口
            state.value(false)
        }
        // Popup.show() 用于设置可组合项是否显示
        show(state.value())
        // Popup.content() 用于设置弹出窗口内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("弹出窗口内容")
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