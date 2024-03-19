package sample.用户界面.Compose.插槽.Slot

/*
功能:
+ 创建 TriStateCheckbox 可组合项

定义:
+ Slot TriStateCheckbox(Closure closure)

参数:
+ Closure closure - 设置 TriStateCheckbox 的闭包
    + 参数 - 无
    + delegate - TriStateCheckbox

返回值:
+ Slot - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Slot.TriStateCheckbox() 方法创建 TriStateCheckbox 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def checkBoxState = mutableStateOf("Off")
    // Slot.TriStateCheckbox() 用于创建 TriStateCheckbox 可组合项
    TriStateCheckbox {
        // delegate -> TriStateCheckbox
        // TriStateCheckbox.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(checkBoxState)
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
// Activity.onDestroy() 方法用于监听Activity销毁
$composeActivity.onDestroy {
    // Script.stop() 方法用于停止脚本
    $script.stop()
}
// Activity.start() 用于启动Android系统的Activity
$composeActivity.start()