package sample.用户界面.Compose.组件.BottomSheetScaffold

/*
功能:
+ 设置底页形状

定义:
+ BottomSheetScaffold sheetShape(Closure closure)

参数:
+ Closure closure - 设置底页形状的闭包
    + 参数 - 无
    + delegate - Shape

返回值:
+ BottomSheetScaffold - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 BottomSheetScaffold.sheetShape() 方法设置底页形状
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.BottomSheetScaffold() 用于创建 BottomSheetScaffold 可组合项
    BottomSheetScaffold {
        // delegate -> BottomSheetScaffold
        // BottomSheetScaffold.sheetShape() 用于设置底页形状
        sheetShape {
            // delegate -> Shape
            // Shape.all() 用于设置四个角尺寸
            all(20, "dp")
            // Shape.roundedCorner() 用于设置角的类型为圆角
            roundedCorner()
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