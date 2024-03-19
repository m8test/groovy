package sample.Shell.Shell

/*
功能:
+ 检查 Shell 是否正在运行命令

定义:
+ boolean isRunning()

参数:
+ 无

返回值:
+ boolean - 如果 Shell 正在运行命令返回true,否则返回false

示例代码:
+ 通过 Shell.isRunning() 检查 Shell 是否正在运行命令
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Shells.newLocalShell() 用于创建一个新的本地 Shell
def shell = $shells.newLocalShell("application")
// Shell.isRunning() 用于检查 Shell 是否正在运行命令
$console.log("isRunning->" + shell.isRunning())
// Shell.exec() 用于执行命令
def shellResult = shell.exec("echo", ["\$\$"])
// ShellResult.output() 用于获取命令执行时所有的输出信息
$console.log(shellResult.output())