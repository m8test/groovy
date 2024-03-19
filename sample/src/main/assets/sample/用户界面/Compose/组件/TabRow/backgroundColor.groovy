package sample.用户界面.Compose.组件.TabRow

/*
功能:
+ 设置选项卡背景颜色

定义:
+ TabRow backgroundColor(Closure closure)

参数:
+ Closure closure - 设置颜色的闭包
    + 参数 - 无
    + delegate - Color

返回值:
+ TabRow - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 TabRow.backgroundColor() 方法设置选项卡背景颜色
 */
def MyTab = { state, tabIndex, iconName, tabText ->
    // delegate -> Slot
    // Slot.Tab() 用于创建 Tab 可组合项
    Tab {
        // delegate -> Tab
        // Tab.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // Tab.selected() 用于设置 Tab 是否选中
        selected(state.value() == tabIndex)
        // Tab.onClick() 用于设置 Tab 点击事件
        onClick {
            // 更新状态
            state.value(tabIndex)
        }
        // Tab.selectedContentColor() 用于设置 Tab 被选择时的内容颜色
        selectedContentColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
        }
        // Tab.unselectedContentColor() 用于设置 Tab 未被选择时的内容颜色
        unselectedContentColor {
            // delegate -> Color
            // Color.green() 用于配置绿色通道
            green(255)
        }
        // Tab.icon() 用于设置 Tab 图标
        icon {
            // delegate -> Slot
            // Slot.Icon() 用于创建 Icon 可组合项
            Icon {
                // delegate -> Icon
                // Icon.vector() 用于设置图标矢量图
                vector("Filled", iconName)
            }
        }
        // Tab.text() 用于设置 Tab 文本
        text {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text(tabText)
            }
        }
    }
}
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(0)
    // Slot.TabRow() 用于创建 TabRow 可组合项
    TabRow {
        // delegate -> TabRow
        // TabRow.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // TabRow.backgroundColor() 用于设置选项卡背景颜色
        backgroundColor {
            // delegate -> Color
            // Color.blue() 用于配置蓝色通道
            blue(255)
        }
        // TabRow.selectedTabIndex() 用于设置当前被选择的选项卡索引
        selectedTabIndex(state.value())
        // TabRow.tabs() 用于设置选项卡内容
        tabs {
            // delegate -> Slot
            MyTab.delegate = delegate
            MyTab(state, 0, "Home", "主页")
            MyTab(state, 1, "Settings", "设置")
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