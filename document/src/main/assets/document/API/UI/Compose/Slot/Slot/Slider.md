功能:

+ 创建 [Slider](/API/UI/Compose/Widget/Slider/README.md) 可组合项

定义:

+ [Slot](/API/UI/Compose/Slot/Slot/README.md) Slider(Closure closure)

参数:

+ Closure closure - 设置 [Slider](/API/UI/Compose/Widget/Slider/README.md) 的闭包
    + 参数 - 无
    + delegate - [Slider](/API/UI/Compose/Widget/Slider/README.md)

返回值:

+ [Slot](/API/UI/Compose/Slot/Slot/README.md) - 返回对象本身方便链式调用

示例代码:

+ 启动一个Activity, 并通过 [Slot.Slider()](/API/UI/Compose/Slot/Slot/README.md?id=Slider)
  方法创建 [Slider](/API/UI/Compose/Widget/Slider/README.md) 可组合项

```groovy
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.mutableStateOf() 用于创建一个 MutableState 对象
    def state = mutableStateOf(0.0f)
    // Slot.Slider() 用于创建 Slider 可组合项
    Slider {
        // delegate -> Slider
        // Slider.withSingleStates() 用于设置可组合项使用到的所有 SingleState
        withSingleStates(state)
        // Slider.value() 用于设置 Slider 值
        value(state.value())
        // Slider.onValueChange() 用于设置 Slider 值改变时的监听事件
        onValueChange {
            // 更改状态
            state.value(it)
        }
        // Slider.valueRange() 用于设置 Slider 取值范围
        valueRange {
            // delegate -> ClosedRange
            // ClosedRange.start() 用于设置起始值
            start(0.0f)
            // ClosedRange.end() 用于设置结束值
            end(100.0f)
        }
        // Slider.steps() 用于设置 Slider 增量
        steps(0)
        // Slider.onValueChangeFinished() 用于设置 Slider 值改变结束时监听事件
        onValueChangeFinished {
            $console.log("值改变结束")
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