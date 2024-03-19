package sample.用户界面.Compose.组件.LazyColumn

/*
功能:
+ 设置列表水平方向对齐方式.

定义:
+ LazyColumn horizontalAlignment(String alignment)

参数:
+ String alignment - 水平对齐方式,可选值有
    + Start - 左对齐
    + End - 右对齐
    + CenterHorizontally - 水平居中对齐

返回值:
+ LazyColumn - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 LazyColumn.horizontalAlignment() 方法设置列表水平方向对齐方式.
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.LazyColumn() 用于创建 LazyColumn 可组合项
    LazyColumn {
        // delegate -> LazyColumn
        // LazyColumn.modifier() 用于修饰 Composable
        modifier {
            // delegate -> Modifier
            // Modifier.fillMaxSize() 用于设置填充父可组合项宽度和高度, 参数为填充父可组合项的比例, 取值区间为 0.0f-1.0f
            fillMaxSize(1.0f)
        }
        // LazyColumn.horizontalAlignment() 用于设置列表水平方向对齐方式
        horizontalAlignment("CenterHorizontally")
        // LazyList.content() 用于设置列表内容
        content {
            // delegate -> LazyListScope
            // LazyListScope.item() 用于添加单个项目到列表中
            item {
                // delegate -> Slot
                // Slot.Text() 用于创建文本可组合项
                Text {
                    // delegate -> Text
                    // Text.text() 用于设置文本可组合项内容
                    text("item")
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