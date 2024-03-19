package sample.用户界面.Compose.插槽.Slot

/*
功能:
+ 创建 TextField 可组合项

定义:
+ Slot TextField(Closure closure)

参数:
+ Closure closure - 设置 TextField 的闭包
    + 参数 - 无
    + delegate - TextField

返回值:
+ Slot - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Slot.TextField() 方法创建 TextField 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Column() 用于创建纵向布局
    Column {
        // delegate -> Column
        // Column.content() 用于设置布局内容
        content {
            // delegate -> Slot
            // Slot.mutableStateOf() 用于创建一个 MutableState 对象
            def state = mutableStateOf("")
            // Slot.TextField() 用于创建 TextField 可组合项
            TextField {
                // delegate -> TextField
                // TextField.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(state)
                // TextField.value() 用于设置输入框内容
                value(state.value())
                // TextField.onValueChange() 用于设置输入框内容变化事件
                onValueChange { value ->
                    // 更新状态值
                    state.value(value)
                }
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