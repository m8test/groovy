package sample.用户界面.Compose.状态.SwipeState

/*
功能:
+ 获取状态的目标值。如果正在进行滑动，则这是滑动完成时可滑动对象将设置为动画的值。 如果动画正在运行，则这是该动画的目标值。 最后，如果没有滑动或动画正在进行，则这与 currentValue 相同。

定义:
+ String targetValue()

参数:
+ 无

返回值:
+ String - 状态的目标值,参考 MaterialState.initialValue()

示例代码:
+ 启动一个Activity, 并通过 SwipeState.targetValue() 方法获取状态的目标值
 */
def MyTextButton = { state ->
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
                text("点我")
                // Text.withAggregatedStates() 用于设置可组合项重组需要的聚合状态
                withAggregatedStates((state): ["targetValue"])
                // Text.style() 用于配置文本样式
                style {
                    // delegate -> TextStyle
                    // BackdropScaffoldState.targetValue() 用于获取状态的目标值
                    if (state.targetValue() == "Concealed") {
                        // TextStyle.fontSize() 用于设置字体大小
                        fontSize(20, "sp")
                    } else {
                        // TextStyle.fontSize() 用于设置字体大小
                        fontSize(15, "sp")
                    }
                }
            }
        }
        // TextButton.onClick() 用于处理点击事件
        onClick {
            // BackdropScaffoldState.isConcealed() 用于判断后层是否隐藏
            if (state.isConcealed()) {
                // BackdropScaffoldState.reveal() 用于显示后层
                state.reveal()
            } else {
                // BackdropScaffoldState.conceal() 用于隐藏后层
                state.conceal()
            }
        }
    }
}

// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.newBackdropScaffoldState() 用于创建 BackdropScaffoldState
    def backdropScaffoldState = newBackdropScaffoldState {
        // delegate -> BackdropScaffoldState
    }
    // Slot.BackdropScaffold() 用于创建 BackdropScaffold 可组合项
    BackdropScaffold {
        // delegate -> BackdropScaffold
        // BackdropScaffold.scaffoldState() 用于设置 BackdropScaffoldState
        scaffoldState(backdropScaffoldState)
        // BackdropScaffold.gesturesEnabled() 用于设置是否开启手势
        gesturesEnabled(false)
        // BackdropScaffold.backLayerBackgroundColor() 用于设置后层背景颜色
        backLayerBackgroundColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
        }
        // BackdropScaffold.backLayerContent() 用于设置后层内容
        backLayerContent {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("后层内容")
            }
        }
        // BackdropScaffold.frontLayerContent() 用于设置前层内容
        frontLayerContent {
            // delegate -> Slot
            MyTextButton.delegate = delegate
            MyTextButton(backdropScaffoldState)
        }
        // BackdropScaffold.appBar() 用于设置背景顶部应用程序栏
        appBar {
            // delegate -> Slot
            MyTextButton.delegate = delegate
            MyTextButton(backdropScaffoldState)
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