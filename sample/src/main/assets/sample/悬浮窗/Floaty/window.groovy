package sample.悬浮窗.Floaty

/*
功能:
+ 显示一个悬浮窗口,并返回该窗口对应的 FloatyWindow 对象.

定义:
+ FloatyWindow window(Closure floatyWindowConfig = null, Closure floatyWindowContent)

参数:
+ Closure floatyWindowConfig - 悬浮窗配置闭包,默认为null
    + 参数 - 无
    + delegate - FloatyWindowConfig
+ Closure floatyWindowContent - 悬浮窗内容闭包
    + 参数
        + FloatyWindow floatyWindow - 被创建的窗口
    + delegate - Slot

返回值:
+ FloatyWindow - 悬浮窗口对应的 FloatyWindow 对象.

示例代码:
+ 通过 Floaty.window() 方法显示一个悬浮窗口.
 */
// Floaty.window() 用于显示一个悬浮窗口
$floaty.window({
    // delegate -> FloatyWindowConfig
    // FloatyWindowConfig.title() 用于配置悬浮窗口的标题
    title("这是标题")
}) { floatyWindow ->
    // delegate -> Slot
    // Slot.Surface() 用于创建Surface可组合项
    Surface {
        // delegate -> Surface
        // Composable.modifier() 用于修饰 Composable,Surface 继承自 Composable
        modifier {
            // delegate -> Modifier
            // Modifier.fillMaxSize() 用于设置填充父可组合项宽度和高度, 参数为填充父可组合项的比例, 取值区间为 0.0f-1.0f
            fillMaxSize(1.0f)
        }
        // Surface.content() 用于设置 Surface 可组合项的内容
        content {
            // delegate -> Slot
            // Slot.Column() 用于创建 Column 可组合项
            Column {
                // delegate -> Column
                // Column.content() 用于设置 Column 可组合项中的内容
                content {
                    // delegate -> Slot
                    // Slot.Button() 用于创建 Button 可组合项
                    Button {
                        // delegate-> Button
                        // Button.content() 用于设置 Button 可组合项中的内容
                        content {
                            // delegate -> Slot
                            // Slot.Text() 用于创建 Text 可组合项
                            Text {
                                // delegate -> Text
                                // Text.text() 用于设置 Text 可组合项的文本内容
                                text('关闭悬浮窗')
                            }
                        }
                        // Button.onClick() 用于处理 Button 可组合项的点击事件
                        onClick {
                            // FloatyWindow.close() 用于关闭悬浮窗口
                            floatyWindow.close()
                        }
                    }
                }
            }
        }
    }
}