package sample.用户界面.Compose.组件.BottomNavigationItem

/*
功能:
+ 设置 BottomNavigationItem 是否可用

定义:
+ BottomNavigationItem enabled(boolean value)

参数:
+ boolean value - true表示 BottomNavigationItem 可用,false表示 BottomNavigationItem 不可用

返回值:
+ BottomNavigationItem - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 BottomNavigationItem.enabled() 方法设置 BottomNavigationItem 是否可用
 */
def MyBottomNavigationItem = { state, iconText, labelText, index, isEnabled ->
    // delegate -> RowScopeSlot
    // RowScopeSlot.BottomNavigationItem() 用于创建 BottomNavigationItem
    BottomNavigationItem {
        // delegate -> BottomNavigationItem
        // BottomNavigationItem.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // BottomNavigationItem.enabled() 用于设置 BottomNavigationItem 是否可用
        enabled(isEnabled)
        // BottomNavigationItem.selectedContentColor() 用于设置 BottomNavigationItem 被选中时的颜色
        selectedContentColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
        }
        // BottomNavigationItem.unselectedContentColor() 用于设置 BottomNavigationItem 未被选中时的颜色
        unselectedContentColor {
            // delegate -> Color
            // Color.green() 用于配置绿色通道
            green(255)
        }
        // BottomNavigationItem.onClick() 用于设置 BottomNavigationItem 点击监听事件
        onClick {
            state.value(index)
        }
        // BottomNavigationItem.selected() 用于设置 BottomNavigationItem 是否被选中
        selected(state.value() == index)
        // BottomNavigationItem.icon() 用于设置 BottomNavigationItem 图标
        icon {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text(iconText)
            }
        }
        // BottomNavigationItem.label() 用于设置 BottomNavigationItem 标签
        label {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text(labelText)
            }
        }
    }
}

// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def selectedState = mutableStateOf(0)
    // Slot.BottomNavigation() 用于创建 BottomNavigation 可组合项
    BottomNavigation {
        // delegate -> BottomNavigation
        // BottomNavigation.content() 用于设置 BottomNavigation 内容
        content {
            // delegate -> RowScopeSlot
            MyBottomNavigationItem.delegate = delegate
            MyBottomNavigationItem(selectedState, "#", "首页", 0, true)
            MyBottomNavigationItem(selectedState, "@", "我的", 1, true)
            MyBottomNavigationItem(selectedState, "*", "不可选", 2, false)
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