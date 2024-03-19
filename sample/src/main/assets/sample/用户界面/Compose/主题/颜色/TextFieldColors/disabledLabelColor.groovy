package sample.用户界面.Compose.主题.颜色.TextFieldColors
/*
功能:
+ 设置输入框禁用时标签颜色.

定义:
+ TextFieldColors disabledLabelColor(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ TextFieldColors - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 TextFieldColors.disabledLabelColor() 方法设置输入框禁用时标签颜色.
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
                value("TextField")
                // TextField.enabled() 用于设置输入框是否可用
                enabled(false)
                // TextField.label() 用于设置输入框标签
                label {
                    // delegate -> Slot
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.text() 用于设置文本可组合项内容
                        text("label")
                    }
                }
                // TextField.colors() 用于设置输入框颜色.
                colors {
                    // delegate -> FilledTextFieldColors
                    // FilledTextFieldColors.disabledLabelColor() 用于设置输入框禁用时标签颜色
                    disabledLabelColor {
                        // delegate -> Color
                        // Color.red() 用于配置红色通道
                        red(255)
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