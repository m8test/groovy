package sample.用户界面.Compose.组件.Button.ButtonElevation

/*
功能:
+ 设置按钮悬浮时的海拔.

定义:
+ ButtonElevation hoveredElevation(Number value)

参数:
+ Number value - 需要设置的海拔

返回值:
+ ButtonElevation - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 ButtonElevation.hoveredElevation() 方法设置按钮悬浮时的海拔.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Button() 用于创建 Button 可组合项
    Button {
        // delegate -> Button
        // Button.elevation() 用于设置按钮海拔
        elevation {
            // delegate -> ButtonElevation
            // ButtonElevation.hoveredElevation() 用于设置按钮悬浮时的海拔
            hoveredElevation(20)
        }
        // Button.content() 用于设置按钮内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("Button")
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