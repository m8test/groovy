package sample.协程.Job

/*
功能:
+ 添加协程执行完成/失败/取消回调

定义:
+ DisposableHandle invokeOnCompletion(Closure closure = null)

参数:
+ Closure closure - 在协程运行结束后回调的闭包(正常结束/用户取消/执行过程出现异常等)
    + 参数
        + Throwable e - 协程正常结束为null,其他情况不为null
    + delegate - 无

返回值:
+ DisposableHandle - 可用于取消与该对象关联的已经注册的回调

示例代码:
+ 通过 Job.invokeOnCompletion() 添加协程执行完成/失败/取消回调.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Coroutines.newScope() 用于创建一个新的协程作用域
def scope = $coroutines.newScope {
    // delegate -> CoroutineContext
    // CoroutineContext.dispatcher() 用于配置协程调度器
    dispatcher("Default")
    // CoroutineContext.job() 用于配置Job类型
    job("SupervisorJob")
}
// CoroutineScope.launch() 用于启动一个子协程(如果CoroutineContext设置了Job参数,那么就是启动一个新协程,与启动它的协程没有父子关系)
def job1 = scope.launch {
    // delegate -> CoroutineScope
    // 协程执行失败(异常)
    1 / 0
}
// CoroutineScope.launch() 用于启动一个子协程(如果CoroutineContext设置了Job参数,那么就是启动一个新协程,与启动它的协程没有父子关系)
def job2 = scope.launch {
    // delegate -> CoroutineScope
    $console.log("正常执行协程")
}
// CoroutineScope.launch() 用于启动一个子协程(如果CoroutineContext设置了Job参数,那么就是启动一个新协程,与启动它的协程没有父子关系)
def job3 = scope.launch {
    // delegate -> CoroutineScope
    while (true) {
        // CoroutineScope.delay() 用于协程延时
        delay(100)
    }
}
// CoroutineScope.launch() 用于启动一个子协程(如果CoroutineContext设置了Job参数,那么就是启动一个新协程,与启动它的协程没有父子关系)
def job4 = scope.launch {
    // delegate -> CoroutineScope
    while (true) {
        // CoroutineScope.delay() 用于协程延时
        delay(100)
    }
}
// CoroutineScope.launch() 用于启动一个子协程(如果CoroutineContext设置了Job参数,那么就是启动一个新协程,与启动它的协程没有父子关系)
scope.launch {
    // CoroutineScope.delay() 用于协程延时
    delay(500)
    // Job.cancel() 用于取消协程以及其子协程
    job3.cancel("测试取消job3")
    job4.cancel("测试取消job4")
}

static def getMessage(it) {
    def message = null
    if (it != null) {
        message = it.message()
    }
    return message
}

// Job.invokeOnCompletion() 用于添加协程执行完成/失败/取消回调
job1.invokeOnCompletion {
    $console.log("job1->isCompleted:${job1.isCompleted()},isCancelled:${job1.isCancelled()},exception:${getMessage(it)}")
}
// Job.invokeOnCompletion() 用于添加协程执行完成/失败/取消回调
job2.invokeOnCompletion {
    $console.log("job2->isCompleted:${job2.isCompleted()},isCancelled:${job2.isCancelled()},exception:${getMessage(it)}")
}
// Job.invokeOnCompletion() 用于添加协程执行完成/失败/取消回调
job3.invokeOnCompletion {
    $console.log("job3->isCompleted:${job3.isCompleted()},isCancelled:${job3.isCancelled()},exception:${getMessage(it)}")
}
// Job.invokeOnCompletion() 用于添加协程执行完成/失败/取消回调
def disposable = job4.invokeOnCompletion {
    // 由于此job注册的回调被取消了,所以job4结束时下面代码不会执行,可以和job3对比
    $console.log("job4->isCompleted:${job4.isCompleted()},isCancelled:${job4.isCancelled()},exception:${getMessage(it)}")
}
// DisposableHandle.dispose() 用于处理相应的对象,使其符合垃圾收集的条件.重复调用此函数无效.
disposable.dispose()
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    // Job.join() 用于等待协程执行完成/失败/取消
    job1.join()
}
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    // Job.join() 用于等待协程执行完成/失败/取消
    job2.join()
}
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    // Job.join() 用于等待协程执行完成/失败/取消
    job3.join()
}
// Exceptions.tryToRun() 用于执行异常代码,返回一个 Trier 对象
$exceptions.tryToRun {
    // Job.join() 用于等待协程执行完成/失败/取消
    job4.join()
}