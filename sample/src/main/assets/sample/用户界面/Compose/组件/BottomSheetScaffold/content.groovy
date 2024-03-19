package sample.用户界面.Compose.组件.BottomSheetScaffold

/*
功能:
+ 设置 BottomSheetScaffold 内容

定义:
+ BottomSheetScaffold content(Closure closure)

参数:
+ Closure closure - 设置 BottomSheetScaffold 内容的闭包
    + 参数 - PaddingValues
    + delegate - Slot(Modifier)

返回值:
+ BottomSheetScaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 BottomSheetScaffold.content() 方法设置 BottomSheetScaffold 内容
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.BottomSheetScaffold() 用于创建 BottomSheetScaffold 可组合项
    BottomSheetScaffold {
        // delegate -> BottomSheetScaffold
        // BottomSheetScaffold.content() 用于设置 BottomSheetScaffold 内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("BottomSheetScaffold内容")
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