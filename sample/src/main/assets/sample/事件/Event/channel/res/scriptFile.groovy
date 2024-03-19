package sample.事件.Events.subscriber.res

// Events.publisher() 用于获取事件发布器
def publisher = $events.publisher()
// Publisher.publishLocal() 用于发布本地事件
publisher.publishLocal({
    // delegate -> LocalSubscription
    // LocalSubscription.channel() 用于设置本地订阅的频道
    channel("subscription channel")
    // LocalSubscription.id() 用于设置本地订阅的id
    id("subscription id")
}) {
    // delegate -> Event
    // Event.data() 用于设置事件中包含的数据
    data("data from event")
}