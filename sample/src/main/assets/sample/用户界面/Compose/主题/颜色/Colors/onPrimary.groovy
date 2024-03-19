package sample.用户界面.Compose.主题.颜色.Colors

/*
功能1:
+ 设置 onPrimary 颜色.

定义1:
+ Colors onPrimary(Closure closure)

参数1:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值1:
+ Colors - 返回对象本身方便链式调用

功能2:
+ 获取 onPrimary 颜色.

定义2:
+ Color onPrimary()

参数2:
+ 无

返回值2:
+ Color - onPrimary 颜色对象

示例代码:
+ 启动一个Activity, 并通过 Colors.onPrimary() 方法设置 onPrimary 颜色.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.MaterialTheme() 用于创建 MaterialTheme 可组合项
    MaterialTheme {
        // delegate -> MaterialTheme
        // MaterialTheme.colors() 用于设置主题颜色
        colors {
            // delegate -> Colors
            // Colors.onPrimary() 用于设置 onPrimary 颜色
            onPrimary {
                // delegate -> Color
                // Color.red() 用于配置红色通道
                red(255)
            }
        }
        // MaterialTheme.content() 用于设置主题内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.LocalColors() 用于获取 Colors 对应的 CompositionLocal 对象
                def LocalThemeColors = LocalColors()
                // Text.compositionLocal() 用于获取 ProvidableCompositionLocal 的值
                def currentColors = compositionLocal(LocalThemeColors)
                // Colors.onPrimary() 用于获取 onPrimary 颜色
                def onPrimaryColor = currentColors.onPrimary()
                // Text.style() 用于配置文本样式
                style {
                    // delegate -> TextStyle
                    // TextStyle.color() 用于设置文字颜色
                    color {
                        // delegate -> Color
                        // Color.from() 用于从指定 Color 对象复制属性(ARGB)
                        from(onPrimaryColor)
                    }
                }
                // Text.text() 用于设置文本可组合项内容
                text("MaterialTheme")
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