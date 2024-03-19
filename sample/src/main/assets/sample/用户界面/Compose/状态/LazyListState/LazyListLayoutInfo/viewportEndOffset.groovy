package sample.用户界面.Compose.状态.LazyListState.LazyListLayoutInfo

/*
功能:
+ 获取布局视口的结束偏移（以像素为单位）。您可以将其视为可见的最大偏移量。它是延迟列表布局的大小减去 beforeContentPadding 您可以使用它来了解 visibleItemsInfo 中的哪些项目是完全可见的。

定义:
+ int viewportEndOffset()

参数:
+ 无

返回值:
+ int - 偏移量

示例代码:
+ 启动一个Activity, 并通过 LazyListLayoutInfo.viewportEndOffset() 方法获取布局视口的结束偏移（以像素为单位）
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.newLazyListState() 用于创建 LazyListState
    def lazyListState = newLazyListState {
        // delegate -> LazyListState
    }
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def mutableState = mutableStateOf(0)
    // Slot.Row() 用于创建 Row 可组合项
    Row {
        // delegate -> Row
        // Row.content() 用于设置行内容
        content {
            // delegate -> Slot
            // Slot.LazyColumn() 用于创建 LazyColumn 可组合项
            LazyColumn {
                // delegate -> LazyColumn
                // LazyList.state() 用于设置 LazyListState
                state(lazyListState)
                // LazyList.content() 用于设置列表内容
                content {
                    // delegate -> LazyListScope
                    // LazyListScope.items() 用于添加多个项目到列表中
                    items(100) { index, value ->
                        // delegate -> Slot
                        // Slot.Text() 用于创建文本可组合项
                        Text {
                            // delegate -> Text
                            // Text.modifier() 用于修饰 Composable
                            modifier {
                                // delegate -> Modifier
                                // Modifier.height() 用于设置高度
                                height(250)
                            }
                            // Text.text() 用于设置文本可组合项内容
                            text("item$index")
                        }
                    }
                }
            }
            // Slot.Button() 用于创建 Button 可组合项
            Button {
                // delegate -> Button
                // Button.content() 用于设置按钮内容
                content {
                    // delegate -> Slot
                    // Slot.Text() 用于创建文本可组合项
                    Text {
                        // delegate -> Text
                        // Text.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                        withSingleStates(mutableState)
                        text("viewportEndOffset:" + mutableState.value())
                    }
                }
                // Button.onClick() 用于处理点击事件
                onClick {
                    // LazyListState.layoutInfo() 用于获取 LazyListLayoutInfo 对象
                    def layoutInfo = lazyListState.layoutInfo()
                    // LazyListLayoutInfo.viewportEndOffset() 用于获取布局视口的结束偏移（以像素为单位）。
                    def count = layoutInfo.viewportEndOffset()
                    // MutableState.value() 用于设置 MutableState 对象的值.
                    mutableState.value(count)
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