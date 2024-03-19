package sample.用户界面.Compose.组件.Composable
/*
功能:
+ 设置可组合项所使用到的所有 MutableState .

定义:
+ Composable withSingleStates(MutableState... states)

参数:
+ MutableState... states - 可组合项使用到的所有 MutableState 对象,可传多个.

返回值:
+ Composable - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity显示 TextField 可组合项, 并通过 Composable.withSingleStates() 方法设置 TextField 可组合项使用到的所有 MutableState 以实现对 TextField 内容的编辑.
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
            def state = mutableStateOf("withSingleStates")
            // Slot.TextField() 用于创建一个输入框
            TextField {
                // delegate -> TextField
                // Composable.withSingleStates() 用于设置可组合项使用到的所有 SingleState , 因为 TextField 可组合项继承自 Composable ,所以可以调用 withSingleStates 方法
                withSingleStates(state)
                // TextField.value() 用于设置输入框中的内容
                value(state.value())
                // TextField.onValueChange() 用于监听输入框中内容变化
                onValueChange { textFieldValue ->
                    // MutableState.value() 用于设置 MutableState 对象的值.
                    state.value(textFieldValue)
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