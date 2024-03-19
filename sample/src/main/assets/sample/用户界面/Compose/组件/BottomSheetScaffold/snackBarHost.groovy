package sample.用户界面.Compose.组件.BottomSheetScaffold

/*
功能:
+ 设置 SnackBarHost 可组合项

定义:
+ BottomSheetScaffold snackBarHost(Closure closure)

参数:
+ Closure closure - 设置 SnackBarHost 的闭包
    + 参数 - SnackBarHostState
    + delegate - Slot(Modifier)

返回值:
+ BottomSheetScaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 BottomSheetScaffold.snackBarHost() 方法设置 SnackBarHost 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.newBottomSheetScaffoldState() 用于创建 BottomSheetScaffoldState
    def state = newBottomSheetScaffoldState {
        // delegate -> BottomSheetScaffoldState
    }
    // Slot.BottomSheetScaffold() 用于创建 BottomSheetScaffold 可组合项
    BottomSheetScaffold {
        // delegate -> BottomSheetScaffold
        // BottomSheetScaffold.scaffoldState() 用于设置 BottomSheetScaffoldState
        scaffoldState(state)
        // BottomSheetScaffold.content() 用于设置 BottomSheetScaffold 内容
        content {
            // delegate -> Slot
            // Slot.TextButton() 用于设置文本按钮
            TextButton {
                // delegate -> TextButton
                // TextButton.content() 用于设置按钮内容
                content {
                    // delegate -> Slot
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.text() 用于设置文本可组合项内容
                        text("显示SnackBar")
                    }
                }
                // TextButton.onClick() 用于处理点击事件
                onClick {
                    // 设置状态
                    // BottomSheetScaffoldState.snackBarHostState() 用于获取 SnackBarHostState
                    def snackBarHostState = state.snackBarHostState()
                    // SnackBarHostState.showSnackBar() 用于显示 SnackBar
                    snackBarHostState.showSnackBar("测试SnackBar", null, "Short")
                }
            }
        }
        // BottomSheetScaffoldState.snackBarHost() 用于设置 SnackBarHost 可组合项
        snackBarHost { snackBarHostState ->
            // delegate -> Slot
            // Slot.SnackBarHost() 用于创建 SnackBarHost 可组合项
            SnackBarHost {
                // delegate -> SnackBarHost
                // SnackBarHost.hostState() 用于设置 SnackBarHostState
                hostState(snackBarHostState)
                // SnackBarHost.snackBar() 用于设置 SnackBar 可组合项
                snackBar { data ->
                    // delegate -> Slot
                    // Slot.SnackBar() 用于创建 SnackBar 可组合项
                    SnackBar {
                        // delegate -> SnackBar
                        // SnackBar.snackBarData() 用于设置 SnackBarData
                        snackBarData(data)
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