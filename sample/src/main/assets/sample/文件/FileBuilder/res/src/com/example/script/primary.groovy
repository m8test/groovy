package com.example.script

/*
功能:
+ 配置文件路径为项目资源文件路径,只有在工程脚本中才能使用,文件或者字符串脚本无法调用此方法

定义:
+ FileBuilder res(String path)

参数:
+ String path - 文件路径

返回值:
+ FileBuilder - 返回对象本身方便链式调用

示例代码:
+ 通过 FileBuilder.res() 配置文件路径为项目资源文件路径
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
            // Files.buildFile() 用于构建一个 ScriptFile 对象
            def scriptFile = $files.buildFile {
                // delegate -> FileBuilder
                // FileBuilder.res() 用于配置文件路径为项目资源文件路径
                res("android.png")
            }
            // ImageRequest.file() 用于设置从指定文件获取图片
            file(scriptFile)
            // ImageRequest.format() 用于设置图片格式
            format("png")
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