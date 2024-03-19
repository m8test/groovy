package sample.用户界面.Compose.组件.AndroidView

import android.widget.TextView

/*
功能:
+ 更新View.

定义:
+ AndroidView update(Closure closure)

参数:
+ Closure closure - 更新view的闭包
    + 参数 - View
    + delegate - 无

返回值:
+ AndroidView - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 AndroidView.update() 方法更新View.
 */
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
            // Slot.AndroidView() 用于显示自定义View或者安卓系统提供的View
            AndroidView {
                // delegate - AndroidView
                // AndroidView.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(state)
                // AndroidView.factory() 用于创建View
                factory { context ->
                    def textView = new TextView(context)
                    textView.setText("通过AndroidView显示的文本")
                    textView
                }
                // Android.update() 用于更新View
                update { view ->
                    view.setText("${state.value()}")
                }
            }
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
                        text("点我")
                    }
                }
                // Button.onClick() 用于处理点击事件
                onClick {
                    state.value(state.value() + 1)
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