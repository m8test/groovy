package sample.用户界面.Compose.组件.AsyncImage.ImageRequest

/*
功能:
+ 设置从指定url获取图片

定义:
+ ImageRequest url(String url)

参数:
+ String url - 图片url地址

返回值:
+ ImageRequest - 返回对象本身方便链式调用

示例代码:
+ 启动一个Activity, 并通过 ImageRequest.url() 方法设置从指定url获取图片
 */
// ComposeActivity.createView() 用于创建用户界面
$composeActivity.createView {
    // delegate -> Slot
    // Slot.AsyncImage() 用于创建 AsyncImage 可组合项
    AsyncImage {
        // delegate -> AsyncImage
        // AsyncImage.request() 用于设置图片请求
        request {
            // delegate -> ImageRequest
            // ImageRequest.url() 用于设置从指定url获取图片
            url("https://upload.wikimedia.org/wikipedia/en/4/41/Flag_of_India.svg")
            // ImageRequest.format() 用于设置图片格式
            format("svg")
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