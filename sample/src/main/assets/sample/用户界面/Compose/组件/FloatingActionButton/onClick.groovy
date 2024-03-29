package sample.用户界面.Compose.组件.FloatingActionButton

/*
功能:
+ 设置悬浮按钮点击事件.

定义:
+ FloatingActionButton onClick(Closure closure)

参数:
+ Closure closure - 设置点击事件的闭包
    + 参数 - 无
    + delegate - 无

返回值:
+ FloatingActionButton - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 FloatingActionButton.onClick() 方法设置悬浮按钮点击事件.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.FloatingActionButton() 用于创建 FloatingActionButton 可组合项
    FloatingActionButton {
        // delegate -> FloatingActionButton
        // FloatingActionButton.onClick() 用于设置悬浮按钮点击事件
        onClick {
            $console.log("悬浮按钮被点击了")
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