package sample.用户界面.Compose.主题.颜色.CheckboxColors

/*
功能:
+ 设置 Checkbox 复选标记颜色.

定义:
+ CheckboxColors checkmarkColor(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ CheckboxColors - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 CheckboxColors.checkmarkColor() 方法设置 Checkbox 复选标记颜色.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(false)
    // Slot.Checkbox() 用于创建 Checkbox 可组合项
    Checkbox {
        // delegate -> Checkbox
        // Checkbox.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // Checkbox.colors() 用于设置 Checkbox 颜色
        colors {
            // delegate -> CheckboxColors
            // CheckboxColors.checkmarkColor() 用于设置 Checkbox 复选标记颜色
            checkmarkColor {
                // delegate -> Color
                // Color.red() 用于配置红色通道
                red(255)
            }
        }
        // Checkbox.checked() 用于设置 Checkbox 是否选中
        checked(state.value())
        // Checkbox.onCheckedChange() 用于设置 Checkbox 选中/取消选中监听器
        onCheckedChange { isChecked ->
            // 更新状态
            state.value(isChecked)
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