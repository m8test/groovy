package sample.事件.Subscriber.subscribeGlobal.res

// Events.publisher() 用于获取事件发布器
def publisher = $events.publisher()
// Publisher.publishGlobal() 用于发布全局事件
publisher.publishGlobal({
    // delegate -> GlobalSubscription
    // GlobalSubscription.channel() 用于设置全局订阅的频道
    channel("subscription channel")
    // GlobalSubscription.id() 用于设置全局订阅的id
    id("subscription id")
}) {
    // delegate -> Event
    // Event.data() 用于设置事件中包含的数据
    data("data from event")
}