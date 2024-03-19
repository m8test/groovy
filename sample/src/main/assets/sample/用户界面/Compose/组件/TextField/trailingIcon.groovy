package sample.用户界面.Compose.组件.TextField

/*
功能:
+ 设置输入框尾部图标.

定义:
+ TextField trailingIcon(Closure closure)

参数:
+ Closure closure - 设置图标的闭包
    + 参数 - 无
    + delegate - Slot(Modifier)

返回值:
+ TextField - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 TextField.trailingIcon() 方法设置输入框尾部图标.
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
            // Slot.TextField() 用于创建 TextField 可组合项
            TextField {
                // delegate -> TextField
                // TextField.value() 用于设置输入框内容
                value("content")
                // TextField.trailingIcon() 用于设置输入框尾部图标
                trailingIcon {
                    // delegate -> Slot
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.text() 用于设置文本可组合项内容
                        text("x")
                    }
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