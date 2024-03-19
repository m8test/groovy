package sample.用户界面.Compose.状态.BottomDrawerState

/*
功能:
+ 判断抽屉是否展开

定义:
+ boolean isExpanded()

参数:
+ 无

返回值:
+ boolean - true表示抽屉为展开状态,false表示抽屉为非展开状态

示例代码:
+ 启动一个Activity, 并通过 BottomDrawerState.isExpanded() 方法判断抽屉是否展开
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.newBottomDrawerState() 用于创建 BottomDrawerState
    def state = newBottomDrawerState {
        // delegate -> BottomDrawerState
    }
    // Slot.BottomDrawer() 用于创建 BottomDrawer 可组合项
    BottomDrawer {
        // delegate -> BottomDrawer
        // BottomDrawer.drawerState() 用于设置 BottomDrawerState
        drawerState(state)
        // BottomDrawer.gesturesEnabled() 用于设置是否开启手势功能
        gesturesEnabled(false)
        // BottomDrawer.drawerContent() 用于设置 BottomDrawer 抽屉内容
        drawerContent {
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
                        text("关闭抽屉")
                    }
                }
                // TextButton.onClick() 用于处理点击事件
                onClick {
                    // BottomDrawerState.isExpanded() 用于判断抽屉是否展开
                    $assert.assertTrue(state.isExpanded(), "抽屉为展开状态")
                    // BottomDrawerState.close() 用于关闭抽屉
                    state.close()
                }
            }
        }
        // BottomDrawer.content() 用于设置 BottomDrawer 内容
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
                        text("展开抽屉")
                        // Text.withAggregatedStates() 用于设置可组合项重组需要的聚合状态
                        withAggregatedStates((state): ["isClosed"])
                        // Text.style() 用于配置文本样式
                        style {
                            // delegate -> TextStyle
                            // BottomDrawerState.isClosed() 用于判断后层是否隐藏
                            if (state.isClosed()) {
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
                    // BottomDrawerState.expand() 用于展开抽屉
                    state.expand()
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