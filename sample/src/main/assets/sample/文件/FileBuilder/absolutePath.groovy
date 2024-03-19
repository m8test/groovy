package sample.文件.FileBuilder

/*
功能:
+ 设置文件绝对路径, 如果路径为应用私有目录(Files.filesDir())或者外部空间中的应用私有目录(Files.externalFilesDir())就不需要权限, 其他路径需要具有权限才可以

定义:
+ FileBuilder absolutePath(String parent, String child = null)

参数:
+ String parent - 父路径,绝对路径
+ String child - 子路径

返回值:
+ FileBuilder - 返回对象本身方便链式调用

示例代码:
+ 通过 FileBuilder.absolutePath() 设置文件绝对路径
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Files.buildFile() 用于构建一个 ScriptFile 对象
def scriptFile = $files.buildFile {
    // delegate -> FileBuilder
    // Files.externalFilesDir() 用于获取外部空间中的应用私有目录
    def sdcardPath = $files.externalFilesDir("sdcard")
    // FileBuilder.absolutePath() 用于设置文件绝对路径
    absolutePath(sdcardPath, 'test_absolutePath.txt')
}
// ScriptFile.writeText() 用于向文件中写入文本数据
scriptFile.writeText('absolutePath')
// 断言文件内容
$assert.assertTrue(scriptFile.readText() == 'absolutePath', "test_absolutePath.txt文件内容")