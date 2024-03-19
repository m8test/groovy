package sample.用户界面.Compose.主题.形状.Shapes

/*
功能1:
+ 设置主题 small 形状

定义1:
+ Shapes small(Closure closure)

参数1:
+ Closure closure - 设置形状的闭包
    + 参数 - 无
    + delegate - Shape

返回值1:
+ Shapes - 返回对象本身方便链式调用

功能2:
+ 获取主题 small 形状

定义2:
+ Shape small()

参数2:
+ 无

返回值2:
+ Shape - small 形状对象

示例代码:
+ 启动一个Activity, 并通过 Shapes.small() 方法设置/获取主题 small 形状
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.MaterialTheme() 用于创建 MaterialTheme 可组合项
    MaterialTheme {
        // delegate -> MaterialTheme
        // MaterialTheme.shapes() 用于设置主题形状
        shapes {
            // delegate -> Shapes
            // Shapes.small() 用于设置主题 small 形状
            small {
                // delegate -> Shape
                // Shape.all() 用于设置四个角尺寸
                all(20, "dp")
                // Shape.roundedCorner() 用于设置角的类型为圆角
                roundedCorner()
            }
        }
        // MaterialTheme.content() 用于设置主题内容
        content {
            // delegate -> Slot
            // Slot.Button() 用于创建 Button 可组合项
            Button {
                // delegate -> Button
                // Button.LocalShapes() 用于获取 Shapes 对应的 CompositionLocal 对象
                def LocalThemeShapes = LocalShapes()
                // Button.compositionLocal() 用于获取 ProvidableCompositionLocal 的值
                def currentShapes = compositionLocal(LocalThemeShapes)
                // Shapes.small() 用于获取主题 small 形状
                def smallShape = currentShapes.small()
                // Button.shape() 用于设置按钮形状
                shape {
                    // delegate -> Shape
                    // Shape.from() 用于从指定 Shape 对象复制属性
                    from(smallShape)
                }
                // Button.content() 用于设置按钮内容
                content {
                    // delegate -> Slot
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.text() 用于设置文本可组合项内容
                        text("MaterialTheme")
                    }
                }
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