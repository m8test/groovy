package sample.用户界面.Compose.组件.IconButton

/*
功能:
+ 设置图标按钮点击事件.

定义:
+ IconButton onClick(Closure closure)

参数:
+ Closure closure - 设置点击事件的闭包
    + 参数 - 无
    + delegate - 无

返回值:
+ IconButton - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 IconButton.onClick() 方法设置图标按钮点击事件.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.IconButton() 用于创建 IconButton 可组合项
    IconButton {
        // delegate -> IconButton
        // IconButton.onClick() 用于设置图标按钮点击事件
        onClick {
            $console.log("图标按钮被点击了")
        }
        // IconButton.content() 用于设置图标按钮内容
        content {
            // delegate -> Slot
            // Slot.Icon() 用于创建 Icon 可组合项
            Icon {
                // delegate -> Icon
                // Icon.contentDescription() 用于设置图标内容描述
                contentDescription("添加")
                // Icon.tint() 用于设置图标颜色
                tint {
                    // delegate -> Color
                    // Color.red() 用于配置红色通道
                    red(255)
                }
                // Icon.vector() 用于设置图标矢量图
                vector("Filled", "Add")
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