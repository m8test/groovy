功能:

+ 设置 [NavigationRail](/API/UI/Compose/Widget/NavigationRail/README.md) 海拔.

定义:

+ [NavigationRail](/API/UI/Compose/Widget/NavigationRail/README.md) elevation(Number elevation)

参数:

+ Number elevation - 需要设置的海拔

返回值:

+ [NavigationRail](/API/UI/Compose/Widget/NavigationRail/README.md) - 返回对象本身方便链式调用

示例代码:

+ 启动一个Activity,
  并通过 [NavigationRail.elevation()](/API/UI/Compose/Widget/NavigationRail/README.md?id=elevation)
  方法设置 [NavigationRail](/API/UI/Compose/Widget/NavigationRail/README.md) 海拔.

```groovy
def MyNavigationRailItem = { state, index, iconName, labelName ->
    // delegate -> Slot
    // Slot.NavigationRailItem() 用于创建 NavigationRailItem 可组合项
    NavigationRailItem {
        // delegate -> NavigationRailItem
        // NavigationRailItem.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // NavigationRailItem.selected() 用于设置 NavigationRailItem 是否被选中
        selected(state.value() == index)
        //  NavigationRailItem.selectedContentColor() 用于设置  NavigationRailItem 被选中时的颜色
        selectedContentColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
        }
        //  NavigationRailItem.unselectedContentColor() 用于设置  NavigationRailItem 未被选中时的颜色
        unselectedContentColor {
            // delegate -> Color
            // Color.green() 用于配置绿色通道
            green(255)
        }
        // NavigationRailItem.onClick() 用于设置 NavigationRailItem 点击事件
        onClick {
            state.value(index)
        }
        // NavigationRailItem.label() 用于设置 NavigationRailItem 标签
        label {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text(labelName)
            }
        }
        // NavigationRailItem.icon() 用于设置 NavigationRailItem 图标
        icon {
            // delegate -> Slot
            // Slot.Icon() 用于创建 Icon 可组合项
            Icon {
                // delegate -> Icon
                // Icon.vector() 用于设置图标矢量图
                vector("Filled", iconName)
            }
        }
    }
}

// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(0)
    // Slot.NavigationRail() 用于创建 NavigationRail 可组合项
    NavigationRail {
        // delegate -> NavigationRail
        // NavigationRail.elevation() 用于设置 NavigationRail 海拔
        elevation(20)
        // NavigationRail.content() 用于设置 NavigationRail 内容
        content {
            // delegate -> Slot
            MyNavigationRailItem.delegate = delegate
            MyNavigationRailItem(state, 0, "Home", "主页")
            MyNavigationRailItem(state, 1, "Settings", "设置")
            MyNavigationRailItem(state, 2, "Favorite", "喜欢")
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
```