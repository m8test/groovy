package sample.用户界面.Compose.组件.Checkbox

/*
功能:
+ 设置 Checkbox 是否启用.

定义:
+ Checkbox enabled(boolean value)

参数:
+ boolean value - true表示启用,false表示不启用

返回值:
+ Checkbox - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Checkbox.enabled() 方法设置 Checkbox 是否启用.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Checkbox() 用于创建 Checkbox 可组合项
    Checkbox {
        // delegate -> Checkbox
        // Checkbox.enabled() 用于设置 Checkbox 是否启用
        enabled(false)
    }
}
// Activity.onDestroy() 方法用于监听Activity销毁
$composeActivity.onDestroy {
    // Script.stop() 方法用于停止脚本
    $script.stop()
}
// Activity.start() 用于启动Android系统的Activity
$composeActivity.start()