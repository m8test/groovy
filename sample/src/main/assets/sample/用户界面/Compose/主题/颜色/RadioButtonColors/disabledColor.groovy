package sample.用户界面.Compose.主题.颜色.RadioButtonColors

/*
功能:
+ 设置 RadioButton 禁用时的颜色.

定义:
+ RadioButtonColors disabledColor(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ RadioButtonColors - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 RadioButtonColors.disabledColor() 方法设置 RadioButton 禁用时的颜色.
 */
def MyRadioButton = { state, index, selectionText, isEnabled ->
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
                // RadioButton.enabled() 用于设置 RadioButton 是否可用
                enabled(isEnabled)
                // RadioButton.selected() 用于设置 RadioButton 是否选中
                selected(state.value() == index)
                // RadioButton.onClick() 用于设置 RadioButton 点击事件
                onClick {
                    // 更新状态
                    state.value(index)
                }
                // RadioButton.colors() 用于设置 RadioButton 颜色
                colors {
                    // delegate -> RadioButtonColors
                    // RadioButtonColors.disabledColor() 用于设置 RadioButton 禁用时的颜色
                    disabledColor {
                        // delegate -> Color
                        // Color.red() 用于配置红色通道
                        red(255)
                    }
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
            MyRadioButton(state, 0, "java", true)
            MyRadioButton(state, 1, "python", true)
            MyRadioButton(state, 2, "groovy", true)
            MyRadioButton(state, 3, "javascript", true)
            MyRadioButton(state, 4, "ruby", true)
            MyRadioButton(state, 5, "lua", false)
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