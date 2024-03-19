package sample.网络.通用.HttpCookie

/*
功能:
+ 获取cookie secure属性的值.

定义:
+ boolean secure()

参数:
+ 无

返回值:
+ boolean - Cookie secure属性的值

示例代码:
+ 在8080端口开启一个服务器,通过 HttpCookie.secure() 获取cookie secure属性的值.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 在8080端口新建一个服务器
def server = $httpServerManager.newServer(8080) {
    // delegate -> HttpServerConfig
    // HttpServerConfig.routing() 用于配置服务器路由信息
    routing {
        // delegate -> HttpServerRouting
        // HttpServerRouting.get() 用于配置Get路由
        get("/secure") {
            // delegate -> HttpServerCall
            // HttpServerCall.request() 可以获得请求对象HttpServerRequest
            def request = request()
            // HttpServerRequest.path() 可获得访问路径,此处为 "/secure"
            def path = request.path()
            $assert.assertTrue(path == "/secure")
            $console.log("Path->$path")
            // HttpServerCall.response() 可以获取响应对应HttpServerResponse
            def response = response()
            // HttpServerResponse.cookie() 用于设置cookie信息
            response.cookie(name: "cookie", value: "cookieValue", secure: false)
            // HttpServerResponse.textBody() 可以发送文本到客户端
            response.textBody(path)
        }
    }
}
// HttpServer.start() 用于启动服务器,如果端口已经被占用了则会启动失败,报错 "Address already in use"
server.start()
// 新建一个Http客户端, HttpClientManager.newClient() 用于创建一个Http客户端
def client = $httpClientManager.newClient()
// HttpClient.request() 会返回一个 HttpClientResponse 对象,封装了Http响应信息
def response = client.request("http://localhost:8080/secure") {
    // delegate -> HttpClientRequest
    // HttpClientRequest.method() 用于配置请求方法,此处为配置为Get请求.除此之外,还有post,put,patch,delete,head,options等方法
    method "get"
}
// HttpClientResponse.cookies() 用于获取cookie信息
def cookies = response.cookies()
def cookie = cookies[0]
// HttpCookie.secure() 用于获取Cookie secure属性的值.
def secure = cookie.secure()
// 断言secure
$assert.assertFalse(secure, "secure")
// HttpClientResponse.textBody() 可以将服务器返回结果转成文本
def textResult = response.textBody()
$console.log("服务器返回结果:$textResult")
// 断言返回结果为"/secure"
$assert.assertTrue(textResult == "/secure", "返回结果为 /secure")
// HttpServer.stop() 用于停止服务器.
server.stop()