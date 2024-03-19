package sample.用户界面.Compose.插槽.ExposedDropdownMenuBoxScopeSlot

/*
功能:
+ 创建 ExposedDropdownMenu 可组合项

定义:
+ ExposedDropdownMenuBoxScopeSlot ExposedDropdownMenu(Closure closure)

参数:
+ Closure closure - 设置 ExposedDropdownMenu 的闭包
    + 参数 - 无
    + delegate - ExposedDropdownMenu

返回值:
+ ExposedDropdownMenuBoxScopeSlot - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 ExposedDropdownMenuBoxScopeSlot.ExposedDropdownMenu() 方法创建 ExposedDropdownMenu 可组合项
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(false)
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def selectedState = mutableStateOf("")
    // Slot.ExposedDropdownMenuBox() 用于创建 ExposedDropdownMenuBox 可组合项
    ExposedDropdownMenuBox {
        // delegate -> ExposedDropdownMenuBox
        // ExposedDropdownMenuBox.onExpandedChange() 用于设置下拉菜单盒子展开状态改变监听器
        onExpandedChange {
            state.value(it)
        }
        // ExposedDropdownMenuBox.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // ExposedDropdownMenuBox.expanded() 用于设置下拉菜单盒子是否展开
        expanded(state.value())
        // ExposedDropdownMenuBox.content() 用于设置下拉菜单盒子内容
        content {
            // delegate -> ExposedDropdownMenuBoxScopeSlot
            // Slot.TextField() 用于创建 TextField 可组合项
            TextField {
                // delegate -> TextField
                // TextField.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(selectedState)
                // TextField.value() 用于设置输入框内容
                value(selectedState.value())
            }
            // ExposedDropdownMenuBoxScopeSlot.ExposedDropdownMenu() 用于创建 ExposedDropdownMenu 可组合项
            ExposedDropdownMenu {
                // delegate -> ExposedDropdownMenu
                // ExposedDropdownMenu.withSingleStates() 用于设置可组合项使用到的所有 SingleState
                withSingleStates(state)
                // ExposedDropdownMenu.onDismissRequest() 用于设置下拉菜单取消时监听事件
                onDismissRequest {
                    // 隐藏下拉菜单
                    state.value(false)
                }
                // ExposedDropdownMenu.expanded() 用于设置下拉菜单是否展开
                expanded(state.value())
                // ExposedDropdownMenu.content() 用于设置下拉菜单内容
                content {
                    // delegate -> Slot
                    // Slot.DropdownMenuItem() 用于创建 DropdownMenuItem 可组合项
                    DropdownMenuItem {
                        // delegate -> DropdownMenuItem
                        // DropdownMenuItem.content() 用于设置下拉菜单项内容
                        content {
                            // delegate -> Slot
                            // Slot.Text() 用于创建文本可组合项
                            Text {
                                // delegate -> Text
                                // Text.text() 用于设置文本可组合项内容
                                text("菜单项1")
                            }
                        }
                        // DropdownMenuItem.onClick() 用于设置下拉菜单项点击事件
                        onClick {
                            selectedState.value("菜单项1")
                            state.value(false)
                        }
                    }
                    // Slot.DropdownMenuItem() 用于创建 DropdownMenuItem 可组合项
                    DropdownMenuItem {
                        // delegate -> DropdownMenuItem
                        // DropdownMenuItem.content() 用于设置下拉菜单项内容
                        content {
                            // delegate -> Slot
                            // Slot.Text() 用于创建文本可组合项
                            Text {
                                // delegate -> Text
                                // Text.text() 用于设置文本可组合项内容
                                text("菜单项2")
                            }
                        }
                        // DropdownMenuItem.onClick() 用于设置下拉菜单项点击事件
                        onClick {
                            selectedState.value("菜单项2")
                            state.value(false)
                        }
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