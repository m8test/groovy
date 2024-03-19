package sample.用户界面.Compose.插槽.Slot

/*
功能:
+ 创建 FilterChip 可组合项

定义:
+ Slot FilterChip(Closure closure)

参数:
+ Closure closure - 设置 FilterChip 的闭包
    + 参数 - 无
    + delegate - FilterChip

返回值:
+ Slot - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Slot.FilterChip() 方法创建 FilterChip 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.FilterChip() 用于创建 FilterChip 可组合项
    FilterChip {
        // delegate -> FilterChip
        // FilterChip.content() 用于设置 FilterChip 内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("FilterChip")
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