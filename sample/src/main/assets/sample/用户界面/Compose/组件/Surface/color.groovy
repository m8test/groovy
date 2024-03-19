package sample.用户界面.Compose.组件.Surface

/*
功能:
+ 设置 Surface 背景颜色

定义:
+ Surface color(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ Surface - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Surface.color() 方法设置 Surface 背景颜色
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Surface() 用于创建 Surface 可组合项
    Surface {
        // delegate -> Surface
        // Surface.color() 用于设置 Surface 背景颜色
        color {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
        }
        // Surface.content() 用于设置 Surface 内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("Surface")
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