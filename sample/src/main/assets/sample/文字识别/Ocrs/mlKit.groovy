package sample.文字识别.Ocrs

/*
功能:
+ 创建 MlKitOcr 对象.

定义:
+ MlKitOcr mlKit(Closure closure)

参数:
+ Closure closure - 配置 MlKitOcr 的闭包
    + 参数 - 无
    + delegate - MlKitOcrConfig

返回值:
+ MlKitOcr - 根据配置创建的 MlKitOcr 对象

示例代码:
+ 通过 Ocrs.mlKit() 创建 MlKitOcr 对象.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Ocrs.mlKit() 用于创建 MlKitOcr 对象
def ocr = $ocrs.mlKit {
    // delegate -> MlKitOcrConfig
    // MlKitOcrConfig.addLanguage() 用于添加语言
    addLanguage("chinese", "cn")
}
// Ocr.getText() 用于获取图片中的文字,此处使用别名,当然也可以使用原名"chinese"
def result = ocr.getText($images.read {
    url('https://s1.ax1x.com/2022/10/29/x55lh4.png')
}, 'cn')
// 断言识别结果
$assert.assertTrue(result == 't言诗', 'Ocr识别结果')