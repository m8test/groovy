package sample.异常.Throwable

/*
功能:
+ 获取导致此 Throwable 的原因,如果原因不存在或者未知则返回null.(原因是导致这个Throwable被抛出的Throwable)

定义:
+ Throwable cause()

参数:
+ 无

返回值:
+ Throwable - 导致当前Throwable被抛出的对象,如果没有返回null

示例代码:
+ 通过 Throwable.cause() 获取导致此 Throwable 的原因.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    1 / 0
}.catchAll {
    // Throwable.cause() 用于获取导致此 Throwable 的原因.
    $assert.assertTrue(it.cause() == null, "原因为null")
}