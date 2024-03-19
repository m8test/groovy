package sample.用户界面.Compose.组件.Scaffold

/*
功能:
+ 设置 Scaffold 内容颜色

定义:
+ Scaffold contentColor(Closure closure)

参数:
+ Closure closure - 设置 Scaffold 内容颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ Scaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Scaffold.contentColor() 方法设置 Scaffold 内容颜色
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Scaffold() 用于创建 Scaffold 可组合项
    Scaffold {
        // delegate -> Scaffold
        // Scaffold.content() 用于设置 Scaffold 内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("Scaffold内容")
            }
        }
        // Scaffold.contentColor() 用于设置 Scaffold 内容颜色
        contentColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
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