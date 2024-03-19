package sample.文件.Files

/*
功能:
+ 获取应用私有目录

定义:
+ String filesDir()

参数:
+ 无

返回值:
+ String - 应用私有目录

示例代码:
+ 通过 Files.filesDir() 获取应用私有目录
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Files.filesDir() 用于获取应用私有目录
$console.log($files.filesDir())