package com.example.script


// ---------------------使用初始化脚本开始-------------------------

// 插件已经在初始化脚本中初始化
def plugin = PluginInitializer.plugin
// DexPlugin.classLoader() 用于获取类加载器
def classLoader = plugin.classLoader()
// DexClassLoader.loadClass() 用于加载指定的类
def clazz = classLoader.loadClass("com.plugin.pluginapk.Test")
// 创建对象
def dex = clazz.newInstance()
// 调用Native(C/C++)方法
$console.log(dex.getNativeValue())
// 调用实例方法
$console.log(dex.getInstanceValue())
// 调用静态方法
$console.log(dex.getStaticValue())
// 调用静态Native(C/C++)方法
$console.log(dex.getStaticNativeValue())

// 初始化时插件加载的类
def testInstance = new com.plugin.pluginapk.Test()
// 调用Native(C/C++)方法
$console.log(testInstance.getNativeValue())
// 调用实例方法
$console.log(testInstance.getInstanceValue())
// 调用静态方法
$console.log(testInstance.getStaticValue())
// 调用静态Native(C/C++)方法
$console.log(testInstance.getStaticNativeValue())

// ---------------------使用初始化脚本结束-------------------------


// ---------------------使用库开始-------------------------

// MathUtil是lib中groovy文件的类
$console.log(MathUtil.add(1, 2))
// com.plugin.pluginjar.Test是lib中pluginjar.jar中的类
def jar = new com.plugin.pluginjar.Test()
// 调用实例方法
$console.log(jar.getInstanceValue())
// 调用静态方法
$console.log(jar.getStaticValue())

// ---------------------使用库结束-------------------------

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