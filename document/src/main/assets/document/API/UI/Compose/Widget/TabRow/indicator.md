功能:

+ 设置指示器,指示器表示当前选择了哪个选项卡

定义:

+ [TabRow](/API/UI/Compose/Widget/TabRow/README.md) indicator(Closure closure)

参数:

+ Closure closure - 设置指示器的闭包
    + 参数
        + List\<[TabPosition](/API/UI/Compose/Widget/TabRow/TabPosition/README.md)\> tabPositions - 所有选项卡的位置信息
    + delegate -
      [Slot](/API/UI/Compose/Slot/Slot/README.md)([Modifier](/API/UI/Compose/Modifier/Modifier/README.md))

返回值:

+ [TabRow](/API/UI/Compose/Widget/TabRow/README.md) - 返回对象本身方便链式调用

示例代码:

+ 启动一个Activity, 并通过 [TabRow.indicator()](/API/UI/Compose/Widget/TabRow/README.md?id=indicator) 方法设置指示器

```groovy
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
        // TabRow.selectedTabIndex() 用于设置当前被选择的选项卡索引
        selectedTabIndex(state.value())
        // TabRow.tabs() 用于设置选项卡内容
        tabs {
            // delegate -> Slot
            MyTab.delegate = delegate
            MyTab(state, 0, "Home", "主页")
            MyTab(state, 1, "Settings", "设置")
        }
        // TabRow.indicator() 用于设置指示器
        indicator { tabPositions ->
            // delegate -> Slot
            // Slot.Divider() 用于创建 Divider 可组合项
            Divider {
                // delegate -> Divider
                // Divider.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(state)
                // Divider.modifier() 用于修饰 Composable
                modifier {
                    // delegate -> Modifier
                    // Modifier.tabIndicatorOffset() 用于设置选显卡偏移量
                    tabIndicatorOffset(tabPositions[state.value()])
                }
                // Divider.color() 用于设置分割线颜色
                color {
                    // delegate -> Color
                    // Color.red() 用于配置红色通道
                    red(255)
                }
                // Divider.thickness() 用于设置分割线厚度
                thickness(5)
                // Divider.startIndent() 用于设置分割线起始偏移量
                startIndent(0)
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
```