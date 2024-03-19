package sample.用户界面.Compose.组件.FloatingActionButton.FloatingActionButtonElevation

/*
功能:
+ 设置悬浮按钮获取焦点时的海拔.

定义:
+ FloatingActionButtonElevation focusedElevation(Number value)

参数:
+ Number value - 需要设置的海拔

返回值:
+ FloatingActionButtonElevation - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 FloatingActionButtonElevation.focusedElevation() 方法设置悬浮按钮获取焦点时的海拔.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.FloatingActionButton() 用于创建 FloatingActionButton 可组合项
    FloatingActionButton {
        // delegate -> FloatingActionButton
        // FloatingActionButton.elevation() 用于设置悬浮按钮海拔
        elevation {
            // delegate -> FloatingActionButtonElevation
            // FloatingActionButtonElevation.focusedElevation() 用于设置悬浮按钮获取焦点时的海拔
            focusedElevation(20)
        }
        // FloatingActionButton.content() 用于设置悬浮按钮内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("+")
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