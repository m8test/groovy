package sample.网络.通用.WebSocketSession

/*
功能:
+ 接收到消息(文本/二进制)时回调

定义:
+ WebSocketSession onMessage(Closure callback)

参数:
+ Closure callback - 回调闭包
    + 参数
        + String|byte[] data - 接收到的数据
        + boolean isText - 如果data为文本数据(String)返回true,为二进制数据(byte[])返回false
    + delegate - 无

返回值:
+ WebSocketSession - 返回对象本身方便链式调用

示例代码:
+ 在8080端口开启一个 WebSocket 服务器,通过 WebSocketSession.onMessage() 接收数据.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 在8080端口新建一个服务器
def server = $httpServerManager.newServer(8080) {
    // delegate -> HttpServerConfig
    // HttpServerConfig.routing() 用于配置服务器路由信息
    routing {
        // delegate -> HttpServerRouting
        // HttpServerRouting.webSocket() 用于配置 WebSocket 服务器.
        webSocket("/onMessage") {
            // delegate -> WebSocketSession
            // WebSocketSession.onOpen() 当 WebSocket 第一次成功连接时会调用此闭包
            onOpen {
                $console.log("客户端连接成功->/onMessage")
            }
            // WebSocketSession.onMessage() 当 WebSocket 客户端发送消息到服务器时会回调此闭包
            onMessage { data, isText ->
                if (isText) {
                    $assert.assertTrue(data == "text", "服务器接收到文本数据")
                } else {
                    $assert.assertTrue($strings.fromBytes(data) == "binary", "服务器接收到二进制数据数据")
                }
            }
            // WebSocketSession.onClose() 当 WebSocket 连接断开时调用
            onClose {
                $console.log("与客户端断开连接")
            }
        }
    }
}
// HttpServer.start() 用于启动服务器,如果端口已经被占用了则会启动失败,报错 "Address already in use"
server.start()
// 新建一个Http客户端, HttpClientManager.newClient() 用于创建一个Http客户端
def client = $httpClientManager.newClient()
// HttpClient.webSocket() 用于新建一个 WebSocket 连接
client.webSocket("ws://localhost:8080/onMessage") {
    // delegate -> WebSocketSession
    // WebSocketSession.onOpen() 当 WebSocket 第一次成功连接时会调用此闭包
    onOpen {
        $console.log("连接服务器成功->/onMessage")
        // WebSocketSession.sendText() 用于发送文本数据
        sendText("text")
        // WebSocketSession.sendBinary() 用于发送二进制数据
        sendBinary($strings.toBytes("binary"))
        // WebSocketSession.close() 用于关闭 WebSocket 连接
        close(1000, "正常关闭")
    }
    // WebSocketSession.onClose() 当 WebSocket 连接断开时调用
    onClose {
        $console.log("与服务器断开连接")
    }
}
// 由于 HttpClient.webSocket() 为同步方法,所以此后代码不会被执行,直到 WebSocket 关闭
// HttpServer.stop() 用于停止服务器.
server.stop()