package sample.用户界面.Compose.组件.RadioButton

/*
功能:
+ 设置 RadioButton 是否选中.

定义:
+ RadioButton selected(boolean value)

参数:
+ boolean value - true表示选中,false表示未选中

返回值:
+ RadioButton - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 RadioButton.selected() 方法设置 RadioButton 是否选中.
 */
def MyRadioButton = { state, index, selectionText ->
    // delegate -> Slot
    // Slot.Row() 用于创建 Row 可组合项
    Row {
        // delegate -> Row
        // Row.verticalAlignment() 用于设置 Row 垂直方向对齐方式
        verticalAlignment("CenterVertically")
        // Row.content() 用于设置行内容
        content {
            // delegate -> Slot
            // Slot.RadioButton() 用于创建 RadioButton 可组合项
            RadioButton {
                // delegate -> RadioButton
                // RadioButton.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(state)
                // RadioButton.selected() 用于设置 RadioButton 是否选中
                selected(state.value() == index)
                // RadioButton.onClick() 用于设置 RadioButton 点击事件
                onClick {
                    // 更新状态
                    state.value(index)
                }
            }
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text(selectionText)
            }
        }
    }
}
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(0)
    // Slot.Column() 用于创建 Column 可组合项
    Column {
        // delegate -> Column
        // Column.content() 用于设置 Column 可组合项中的内容
        content {
            // delegate -> Slot
            MyRadioButton.delegate = delegate
            MyRadioButton(state, 0, "java")
            MyRadioButton(state, 1, "python")
            MyRadioButton(state, 2, "groovy")
            MyRadioButton(state, 3, "javascript")
            MyRadioButton(state, 4, "ruby")
            MyRadioButton(state, 5, "lua")
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