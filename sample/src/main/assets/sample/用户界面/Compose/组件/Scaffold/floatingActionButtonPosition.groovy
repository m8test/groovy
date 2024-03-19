package sample.用户界面.Compose.组件.Scaffold

/*
功能:
+ 设置悬浮动作按钮位置

定义:
+ Scaffold floatingActionButtonPosition(String value)

参数:
+ String value - 位置的值,可选值如下
    + Center - 悬浮动作按钮显示在中心
    + End - 悬浮动作按钮显示在右边

返回值:
+ Scaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 Scaffold.floatingActionButtonPosition() 方法设置悬浮动作按钮
 */
def MyFloatingActionButton = {
    // delegate -> Slot
    // Slot.FloatingActionButton() 用于创建 FloatingActionButton 可组合项
    FloatingActionButton {
        // delegate -> FloatingActionButton
        // FloatingActionButton.content() 用于设置悬浮动作按钮内容
        content {
            // delegate -> Slot
            // Slot.Text() 用于创建文本可组合项
            Text {
                // delegate -> Text
                // Text.text() 用于设置文本可组合项内容
                text("按钮")
            }
        }
        // FloatingActionButton.shape() 用于设置悬浮动作按钮形状
        shape {
            // delegate -> Shape
            // Shape.all() 用于设置四个角尺寸
            all(50, "percent")
        }
    }
}

def MyScaffold = {
    // delegate -> Slot
    // Slot.Scaffold() 用于创建 Scaffold 可组合项
    Scaffold {
        // delegate -> Scaffold
        // Scaffold.floatingActionButtonPosition() 用于设置悬浮动作按钮位置
        floatingActionButtonPosition("Center")
        // Scaffold.floatingActionButton() 用于设置悬浮动作按钮
        floatingActionButton {
            // delegate -> Slot
            MyFloatingActionButton.delegate = delegate
            MyFloatingActionButton()
        }
    }
}

// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    MyScaffold.delegate = delegate
    MyScaffold()
}
// Activity.onDestroy() 方法用于监听Activity销毁
$composeActivity.onDestroy {
    // Script.stop() 方法用于停止脚本
    $script.stop()
}
// Activity.start() 用于启动Android系统的Activity
$composeActivity.start()