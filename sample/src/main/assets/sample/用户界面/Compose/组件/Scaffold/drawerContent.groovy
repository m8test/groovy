package sample.用户界面.Compose.组件.Scaffold

/*
功能:
+ 设置抽屉内容

定义:
+ Scaffold drawerContent(Closure closure)

参数:
+ Closure closure - 设置抽屉内容的闭包
    + 参数 - 无
    + delegate - Slot(ColumnScopeModifier)

返回值:
+ Scaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Scaffold.drawerContent() 方法设置抽屉内容
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Scaffold() 用于创建 Scaffold 可组合项
    Scaffold {
        // delegate -> Scaffold
        // Scaffold.drawerContent() 用于设置抽屉内容
        drawerContent {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("抽屉内容")
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