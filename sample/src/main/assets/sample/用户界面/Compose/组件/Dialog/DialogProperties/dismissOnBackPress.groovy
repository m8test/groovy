package sample.用户界面.Compose.组件.Dialog.DialogProperties

/*
功能:
+ 设置按下返回键是否触发 Dialog.onDismissRequest().

定义:
+ DialogProperties dismissOnBackPress(boolean value)

参数:
+ boolean value - true表示按下返回键可以触发 Dialog.onDismissRequest() ,false表示按下返回键不会触发 Dialog.onDismissRequest()

返回值:
+ DialogProperties - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity显示对话框, 并通过 DialogProperties.dismissOnBackPress() 方法设置按下返回键触发 Dialog.onDismissRequest().
 */
def MyDialog = { state ->
    // delegate -> Slot
    // Slot.Dialog() 用于设置对话框
    Dialog {
        // delegate -> Dialog
        // Dialog.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // Dialog.show() 用于显示对话框
        show(state.value())
        // Dialog.dialogProperties() 用于设置对话框属性
        dialogProperties {
            // delegate -> DialogProperties
            // DialogProperties.dismissOnBackPress() 用于设置按下返回键是否触发 Dialog.onDismissRequest()
            dismissOnBackPress(true)
        }
        // Dialog.onDismissRequest() 用于监听对话框取消
        onDismissRequest {
            // 设置状态
            state.value(false)
        }
        // Dialog.content() 用于设置对话框内容
        content {
            // delegate -> Slot
            // Slot.Column() 用于创建 Column 可组合项
            Column {
                // delegate -> Column
                // Column.content() 用于设置 Column 可组合项中的内容
                content {
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.text() 用于设置文本可组合项内容
                        text("对话框例子")
                    }
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
                                text("确定")
                            }
                        }
                        // TextButton.onClick() 用于处理点击事件
                        onClick {
                            // 设置状态
                            state.value(false)
                        }
                    }
                }
            }
        }
    }
}
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(false)
    MyDialog.delegate = delegate
    MyDialog(state)
    // Slot.Button() 用于创建 Button 可组合项
    Button {
        // delegate -> Button
        // Button.content() 用于设置按钮内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("显示对话框")
            }
        }
        // Button.onClick() 用于处理点击事件
        onClick {
            state.value(true)
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