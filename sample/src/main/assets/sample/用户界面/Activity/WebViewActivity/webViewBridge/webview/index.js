document.getElementById("button").addEventListener("click", function (e) {
    // $webViewBridge.callHandler() 用于调用脚本端注册的处理器，参数一为处理器名，参数二为需要传递给处理器的参数，参数三为回调函数用于接收脚本端的返回值
    $webViewBridge.callHandler("handlerForWebView", "params from js", function (result) {
        // result 为脚本端处理器返回的结果
        alert(result)
    })
})