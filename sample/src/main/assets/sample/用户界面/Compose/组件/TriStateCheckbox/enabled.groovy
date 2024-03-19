package sample.用户界面.Compose.组件.TriStateCheckbox

/*
功能:
+ 设置 TriStateCheckbox 是否启用.

定义:
+ TriStateCheckbox enabled(boolean enabled)

参数:
+ boolean enabled - true表示启用,false表示不启用

返回值:
+ TriStateCheckbox - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 TriStateCheckbox.enabled() 方法设置 TriStateCheckbox 是否启用.
 */
def MyTriStateCheckbox = { checkBoxState, isEnabled ->
    // delegate -> Slot
    // Slot.TriStateCheckbox() 用于创建 TriStateCheckbox 可组合项
    TriStateCheckbox {
        // delegate -> TriStateCheckbox
        // TriStateCheckbox.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(checkBoxState)
        // TriStateCheckbox.enabled() 用于设置 TriStateCheckbox 是否启用
        enabled(isEnabled)
        // TriStateCheckbox.state() 用于设置 TriStateCheckbox 状态
        state(checkBoxState.value())
        // TriStateCheckbox.onClick() 用于设置 TriStateCheckbox 点击事件
        onClick {
            def currentValue = checkBoxState.value()
            if (currentValue == "Off") {
                checkBoxState.value("Indeterminate")
            } else if (currentValue == "Indeterminate") {
                checkBoxState.value("On")
            } else {
                checkBoxState.value("Off")
            }
        }
    }
}

// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def checkBoxState = mutableStateOf("Off")
    // Slot.Column() 用于创建 Column 可组合项
    Column {
        // delegate -> Column
        // Column.content() 用于设置 Column 可组合项中的内容
        content {
            // delegate -> Slot
            MyTriStateCheckbox.delegate = delegate
            MyTriStateCheckbox(checkBoxState, true)
            MyTriStateCheckbox(checkBoxState, false)
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