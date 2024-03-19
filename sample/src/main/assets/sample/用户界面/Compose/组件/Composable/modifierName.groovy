package sample.用户界面.Compose.组件.Composable
/*
功能:
+ 获取 Modifier 名字, 可能的值有 BoxScopeModifier, ColumnScopeModifier, ExposedDropdownMenuBoxScopeModifier, LazyItemScopeModifier, Modifier, RowScopeModifier

定义:
+ String modifierName()

参数:
+ 无

返回值:
+ String - Modifier 名

示例代码:
+ 启动一个Activity显示 Text 可组合项, 并通过 Composable.modifierName() 方法获取 Modifier 名.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Column() 用于创建纵向布局
    Column {
        // delegate -> Column
        // Column.content() 用于设置布局内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Composable.modifier() 用于配置可组合项的 Modifier ,因为 Text 可组合项继承自 Composable ,所以可以调用 modifier 方法
                modifier {
                    // delegate -> Modifier
                    // Modifier.modifierName() 用于获取 Modifier 名
                    $assert.assertTrue(modifierName() == "ColumnScopeModifier", "ColumnScopeModifier")
                }
                // Text.text() 用于设置文本可组合项内容
                text("ColumnScopeModifier")
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