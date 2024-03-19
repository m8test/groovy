package sample.事件.Publisher.publishGlobal.res

// Events.subscriber() 用于获取事件订阅器
def subscriber = $events.subscriber()
// Subscriber.subscribeGlobal() 用于订阅全局事件
subscriber.subscribeGlobal({
    // delegate -> GlobalSubscription
    // GlobalSubscription.channel() 用于设置全局订阅的频道
    channel("subscription channel")
    // GlobalSubscription.id() 用于设置全局订阅的id
    id("subscription id")
}) {
    // it -> Event
    // Event.channel() 用于获取事件发布的频道
    $assert.assertTrue(it.channel() == "subscription channel", "事件频道")
    // Event.data() 用于获取事件中包含的数据
    $assert.assertTrue(it.data() == "data from event", "事件数据")
    // Event.time() 用于获取事件发布的时间
    $console.log("事件发布时间->" + it.time())
}
// Threads.mainThread() 用于获取脚本主线程
def mainThread = $threads.mainThread()
// ScriptThread.timer() 用于获取线程对应的定时器
def timer = mainThread.timer()
// Timer.setTimeout() 用于添加一个延时执行的定时任务
timer.setTimeout({
    // 保持脚本3秒钟不结束
}, 3000)