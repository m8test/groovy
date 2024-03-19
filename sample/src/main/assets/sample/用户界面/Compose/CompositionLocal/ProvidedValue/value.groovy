package sample.用户界面.Compose.CompositionLocal.ProvidedValue

/*
功能:
+ 获取提供的值

定义:
+ Object value()

参数:
+ 无

返回值:
+ Object - ProvidableCompositionLocal.provides() 或者 ProvidableCompositionLocal.providesDefault() 中的参数

示例代码:
+ 启动一个Activity, 并通过 ProvidedValue.value() 方法获取提供的值
 */
// CompositionLocals.compositionLocalOf() 用于创建 DynamicProvidableCompositionLocal 对象
def LocalText = $compositionLocals.compositionLocalOf { "Text0" }
def MyText = {
    // delegate -> Slot
    // Slot.Text() 用于创建文本可组合项
    Text {
        // delegate -> Text
        // Text.compositionLocal() 用于获取 ProvidableCompositionLocal 的值
        def currentText = compositionLocal(LocalText)
        // Text.text() 用于设置文本可组合项内容
        text(currentText)
    }
}
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Column() 用于创建 Column 可组合项
    Column {
        // delegate -> Column
        // Column.content() 用于设置 Column 内容
        content {
            // delegate -> Slot
            MyText.delegate = delegate
            MyText()
            // Slot.CompositionLocalProvider() 用于创建 CompositionLocalProvider 可组合项
            CompositionLocalProvider {
                // delegate -> CompositionLocalProvider
                // ProvidableCompositionLocal.provides() 用于将 CompositionLocal 键与值相关联
                def providedValue1 = LocalText.provides("Text1")
                // ProvidedValue.value() 用于获取提供的值
                $assert.assertTrue(providedValue1.value() == "Text1", "value 为 Text1")
                // CompositionLocalProvider.values() 用于设置 ProvidedValue
                values([providedValue1])
                // CompositionLocalProvider.content() 用于设置 CompositionLocalProvider 内容
                content {
                    // delegate -> Slot
                    MyText.delegate = delegate
                    MyText()
                    // Slot.CompositionLocalProvider() 用于创建 CompositionLocalProvider 可组合项
                    CompositionLocalProvider {
                        // delegate -> CompositionLocalProvider
                        // ProvidableCompositionLocal.provides() 用于将 CompositionLocal 键与值相关联
                        def providedValue2 = LocalText.providesDefault("Text2")
                        // ProvidedValue.value() 用于获取提供的值
                        $assert.assertTrue(providedValue2.value() == "Text2", "value 为 Text2")
                        // CompositionLocalProvider.values() 用于设置 ProvidedValue
                        values([providedValue2])
                        // CompositionLocalProvider.content() 用于设置 CompositionLocalProvider 内容
                        content {
                            // delegate -> Slot
                            MyText.delegate = delegate
                            MyText()
                        }
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