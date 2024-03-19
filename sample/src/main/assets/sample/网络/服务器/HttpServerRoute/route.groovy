package sample.网络.服务器.HttpServerRoute

/*
功能:
+ 添加路由到Http服务器.

定义:
+ HttpServerRoute route(String path, Closure closure)

参数:
+ String path - 路由的路径
+ Closure closure - 路由配置闭包
    + 参数 - 无
    + delegate - HttpServerRoute

返回值:
+ HttpServerRoute - 返回对象本身方便链式调用

示例代码:
+ 在8080端口开启一个服务器,通过 HttpServerRoute.route() 添加路由.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// 启动服务器
def server = $httpServerManager.newServer(8080) {
    // delegate -> HttpServerConfig
    routing {
        // delegate -> HttpServerRouting
        // HttpServerRouting.route(path, closure)用于配置路由信息,在closure闭包可继续通过HttpServerRoute.route(path, closure)配置路由,或者通过HttpServerRoute.get(path, closure),HttpServerRoute.post(path, closure)等配置路由
        route("/route") {
            // delegate -> HttpServerRoute
            // HttpServerRoute.get() 用于配置Get请求
            get {
                // delegate -> HttpServerCall
                // HttpServerCall.request() 可以获得请求对象 HttpServerRequest 
                def request = request()
                // HttpServerRequest.path()可获得访问路径,此处为 "/route"
                def path = request.path()
                $console.log("Path->$path")
                // HttpServerCall.response() 可以获取响应对应 HttpServerResponse
                def response = response()
                // HttpServerResponse.textBody() 可以发送文本到客户端
                response.textBody(path)
            }
            // HttpServerRoute.method() 用于配置请求方法
            method("post") {
                // delegate -> HttpServerRoute 
                // HttpServerRoute.handle() 用于处理Http请求
                handle {
                    // delegate -> HttpServerCall 
                    // HttpServerCall.request() 可以获得请求对象 HttpServerRequest 
                    def request = request()
                    // HttpServerRequest.path()可获得访问路径,此处为 "/route"
                    def path = request.path()
                    $console.log("Path->$path")
                    // HttpServerCall.response() 可以获取响应对应 HttpServerResponse
                    def response = response()
                    // HttpServerResponse.textBody() 可以发送文本到客户端
                    response.textBody(path)
                }
            }
        }
    }
}
// HttpServer.start() 用于启动服务器,如果端口已经被占用了则会启动失败,报错 "Address already in use"
server.start()
// 新建一个Http客户端, HttpClientManager.newClient() 用于创建一个Http客户端
def client = $httpClientManager.newClient()
// HttpClient.get() 会返回一个 HttpClientResponse 对象,封装了Http响应信息
def response = client.get("http://localhost:8080/route")
// HttpClientResponse.textBody() 可以将服务器返回结果转成文本
def textResult = response.textBody()
$console.log("服务器返回结果:$textResult")
// 断言返回结果为"/route"
$assert.assertTrue(textResult == "/route", "返回结果为 /route")
// HttpClient.post() 会返回一个 HttpClientResponse 对象,封装了Http响应信息
response = client.post("http://localhost:8080/route")
// HttpClientResponse.textBody() 可以将服务器返回结果转成文本
textResult = response.textBody()
$console.log("服务器返回结果:$textResult")
// 断言返回结果为"/route"
$assert.assertTrue(textResult == "/route", "返回结果为 /route")
// HttpServer.stop() 用于停止服务器.
server.stop()