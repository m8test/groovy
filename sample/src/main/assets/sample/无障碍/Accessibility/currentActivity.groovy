package sample.无障碍.Accessibility

/*
功能:
+ 获取当前Activity类名

定义:
+ String currentActivity()

参数:
+ 无

返回值:
+ String - 当前Activity类名

示例代码:
+ 启动一个Activity, 并通过 Accessibility.currentActivity() 方法获取当前Activity类名
 */
// Accessibility.currentActivity() 用于获取当前Activity类名
def activityName = $accessibility.currentActivity()
$console.log(activityName)