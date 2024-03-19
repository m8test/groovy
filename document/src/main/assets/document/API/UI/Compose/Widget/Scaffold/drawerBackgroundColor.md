功能:

+ 设置抽屉背景颜色

定义:

+ [Scaffold](/API/UI/Compose/Widget/Scaffold/README.md) drawerBackgroundColor(Closure closure)

参数:

+ Closure closure - 设置抽屉背景颜色的闭包
    + 参数 - 无
    + delegate - [Color](/API/UI/Compose/Theme/Color/Color/README.md)

返回值:

+ [Scaffold](/API/UI/Compose/Widget/Scaffold/README.md) - 返回对象本身方便链式调用

示例代码:

+ 启动一个Activity,
  并通过 [Scaffold.drawerBackgroundColor()](/API/UI/Compose/Widget/Scaffold/README.md?id=drawerBackgroundColor)
  方法设置抽屉背景颜色

```groovy
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.Scaffold() 用于创建 Scaffold 可组合项
    Scaffold {
        // delegate -> Scaffold
        // Slot.drawerBackgroundColor() 用于设置抽屉背景颜色
        drawerBackgroundColor {
            // delegate -> Color
            // Color.red() 用于配置红色通道
            red(255)
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