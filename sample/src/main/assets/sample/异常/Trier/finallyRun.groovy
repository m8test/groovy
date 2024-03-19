package sample.异常.Trier

/*
功能:
+ 无论 Exceptions.tryToRun() 有没有产生异常都会调用此方法.

定义:
+ Trier finallyRun(Closure closure)

参数:
+ Closure closure - 需要执行的闭包
    + 参数 - 无
    + delegate - 无

返回值:
+ Trier - 返回对象本身,方便链式调用

示例代码:
+ 通过 Trier.finallyRun() 执行异常产生/没有产生后的代码.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    1 / 0
}.catchAll {
    $console.error("产生异常")
    // Throwable.cause() 用于获取导致此 Throwable 的原因.
    $assert.assertTrue(it.cause() == null, "原因为null")
}.finallyRun {
    $console.log("有异常也会执行")
}
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    $console.log("没有异常")
}.catchAll {
    $console.error("没有异常产生,此代码不会被执行")
    // Throwable.cause() 用于获取导致此 Throwable 的原因.
    $assert.assertTrue(it.cause() == null, "原因为null")
}.finallyRun {
    $console.log("没有异常也会执行")
}