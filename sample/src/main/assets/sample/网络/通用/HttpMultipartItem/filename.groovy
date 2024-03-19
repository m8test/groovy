package sample.网络.通用.HttpMultipartItem

/*
功能:
+ 获取当前part文件名

定义:
+ String filename()

参数:
+ 无

返回值:
+ String - 当前part文件名,如果当前part不是文件,则返回null

示例代码:
+ 在8080端口开启一个服务器,通过 HttpMultipartItem.filename() 获取当前part文件名.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 在8080端口新建一个服务器
def server = $httpServerManager.newServer(8080) {
    // delegate -> HttpServerConfig
    // HttpServerConfig.routing() 用于配置服务器路由信息
    routing {
        // delegate -> HttpServerRouting
        // HttpServerRouting.post() 用于配置Post路由
        post("/filename") {
            // delegate -> HttpServerCall
            // HttpServerCall.request() 可以获得请求对象HttpServerRequest
            def request = request()
            // HttpServerRequest.path() 可获得访问路径,此处为 "/filename"
            def path = request.path()
            $assert.assertTrue(path == "/filename")
            $console.log("Path->$path")
            // HttpServerRequest.multipartBody() 可以接收multipart类型的数据, 返回值类型为 List<HttpMultipartItem>
            def multipart = request.multipartBody()
            // 遍历所有数据
            multipart.each {
                // it -> HttpMultipartItem
                if (it.isFile()) {
                    $console.log("文件类型:${it.name()}")
                    // HttpMultipartItem.filename() 用于获取当前part文件名
                    $assert.assertTrue(it.filename() == "custom_filename_test_http_multipart_item_filename.txt", "文本类型filename不为null")
                } else {
                    $console.log("文本类型:${it.name()}")
                    // HttpMultipartItem.filename() 用于获取当前part文件名
                    $assert.assertTrue(it.filename() == null, "文本类型filename为null")
                }
            }
            // HttpServerCall.response() 可以获取响应对应HttpServerResponse
            def response = response()
            // HttpServerResponse.textBody() 可以发送文本到客户端
            response.textBody(path)
        }
    }
}
// HttpServer.start() 用于启动服务器,如果端口已经被占用了则会启动失败,报错 "Address already in use"
server.start()
// 新建一个Http客户端, HttpClientManager.newClient() 用于创建一个Http客户端
def client = $httpClientManager.newClient()
// HttpClient.postMultipart() 会返回一个 HttpClientResponse 对象,封装了Http响应信息
def response = client.postMultipart("http://localhost:8080/filename", {
    // delegate -> HttpClientMultipart
    // HttpClientMultipart.text() 用于添加文本类型的part
    text("textPartName", "textPartValue")
    // Files.buildFile() 用于构建一个 ScriptFile 对象
    def scriptFile = $files.buildFile {
        // delegate -> FileBuilder
        // FileBuilder.path() 用于设置文件路径
        delegate.path("/sdcard/test_http_multipart_item_filename.txt")
    }
    // ScriptFile.writeText() 可以向文件中写入内容
    scriptFile.writeText("Hello HttpMultipartItem.filename()")
    // HttpClientMultipart.file() 用于添加文件类型的part
    file("filePartName", scriptFile, "custom_filename_test_http_multipart_item_filename.txt")
})
// HttpClientResponse.textBody() 可以将服务器返回结果转成文本
def textResult = response.textBody()
$console.log("服务器返回结果:$textResult")
// 断言返回结果为"/filename"
$assert.assertTrue(textResult == "/filename", "返回结果为 /filename")
// HttpServer.stop() 用于停止服务器.
server.stop()