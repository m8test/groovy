package sample.用户界面.Compose.组件.TextField.KeyboardActions

/*
功能:
+ 设置输入法Search动作响应事件

定义:
+ KeyboardActions onSearch(Closure closure)

参数:
+ Closure closure - 设置输入法Search动作响应事件的闭包
    + 参数 - 无
    + delegate - 无

返回值:
+ KeyboardActions - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 KeyboardActions.onSearch() 方法设置输入法Search动作响应事件
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
            // Slot.TextField() 用于创建 TextField 可组合项
            TextField {
                // delegate -> TextField
                // TextField.value() 用于设置输入框内容
                value("content")
                // TextField.keyboardActions() 用于设置输入法动作(IME Action)响应事件
                keyboardActions {
                    // delegate -> KeyboardActions
                    // KeyboardActions.onSearch() 用于设置输入法Search动作响应事件
                    onSearch {
                        $console.log("onSearch")
                    }
                }
                // TextField.keyboardOptions() 用于设置输入框键盘配置选项
                keyboardOptions {
                    // delegate -> KeyboardOptions
                    // KeyboardOptions.imeAction() 用于设置输入法动作
                    imeAction("Search")
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