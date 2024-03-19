package sample.用户界面.Compose.主题.颜色.Color

/*
功能:
+ 复制颜色,返回一个新的 Color 对象,属性(ARGB)与调用 copy() 的 Color 对象一样

定义:
+ Color copy()

参数:
+ 无

返回值:
+ Color - 复制的新 Color 对象

示例代码:
+ 启动一个Activity, 并通过 Color.copy() 方法复制颜色.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Button() 用于创建 Button 可组合项
    Button {
        // delegate -> Button
        // Button.colors() 用于设置按钮颜色
        colors {
            // delegate -> FilledButtonColors
            // FilledButtonColors.contentColor() 用于设置按钮的内容颜色
            contentColor {
                // delegate -> Color
                // Button.LocalContentColor() 用于获取当前内容颜色对应的 ProvidableCompositionLocal
                def currentLocalContentColor = LocalContentColor()
                // Button.compositionLocal() 用于获取 ProvidableCompositionLocal 的值
                def currentColor = compositionLocal(currentLocalContentColor)
                // Color.copy() 用于复制颜色
                def copiedColor = currentColor.copy()
                // Color.alpha() 用于配置颜色透明度
                copiedColor.alpha(128)
                // Color.from() 用于从指定 Color 对象复制属性(ARGB)
                from(copiedColor)
            }
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