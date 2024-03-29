package sample.用户界面.Compose.状态.ScaffoldState

/*
功能1:
+ 设置 DrawerState

定义1:
+ ScaffoldState drawerState(DrawerState drawerState)

参数1:
+ DrawerState drawerState - 需要设置的 DrawerState

返回值1:
+ ScaffoldState - 返回对象本身方便链式调用

功能2:
+ 获取 DrawerState

定义2:
+ DrawerState drawerState()

参数2:
+ 无

返回值2:
+ DrawerState - DrawerState 对象

示例代码:
+ 启动一个Activity, 并通过 ScaffoldState.drawerState() 方法设置/获取 DrawerState
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.newDrawerState() 用于创建 DrawerState
    def dState = newDrawerState {
        // delegate -> DrawerState
    }
    // Slot.newScaffoldState() 用于新建 ScaffoldState
    def state = newScaffoldState {
        // delegate -> ScaffoldState
        // ScaffoldState.drawerState() 用于设置 DrawerState
        drawerState(dState)
    }
    // Slot.Scaffold() 用于创建 Scaffold 可组合项
    Scaffold {
        // delegate -> Scaffold
        // Scaffold.drawerGesturesEnabled() 用于设置是否开启抽屉手势
        drawerGesturesEnabled(false)
        // Scaffold.scaffoldState() 用于设置 ScaffoldState
        scaffoldState(state)
        // Scaffold.drawerContent() 用于设置抽屉内容
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
                    // ScaffoldState.drawerState() 用于获取 DrawerState
                    def drawerState = state.drawerState()
                    // DrawerState.close() 用于关闭抽屉
                    drawerState.close()
                }
            }
        }
        // Scaffold.content() 用于设置 Scaffold 内容
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
                        text("打开抽屉")
                    }
                }
                // TextButton.onClick() 用于处理点击事件
                onClick {
                    // ScaffoldState.drawerState() 用于获取 DrawerState
                    def drawerState = state.drawerState()
                    // DrawerState.open() 用于打开抽屉
                    drawerState.open()
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