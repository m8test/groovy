package sample.用户界面.Compose.主题.颜色.SelectableChipColors

/*
功能:
+ 设置 FilterChip 被选中时的内容颜色.

定义:
+ SelectableChipColors selectedContentColor(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ SelectableChipColors - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 SelectableChipColors.selectedContentColor() 方法设置 FilterChip 被选中时的内容颜色.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.FilterChip() 用于创建 FilterChip 可组合项
    FilterChip {
        // delegate -> FilterChip
        // FilterChip.selected() 用于设置是否选中 FilterChip
        selected(true)
        // FilterChip.colors() 用于设置 FilterChip 颜色
        colors {
            // delegate -> SelectableChipColors
            // SelectableChipColors.selectedContentColor() 用于设置 FilterChip 被选中时的内容颜色
            selectedContentColor {
                // delegate -> Color
                // Color.red() 用于配置红色通道
                red(255)
            }
        }
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