package sample.Shell.Shell

/*
功能:
+ 关闭 Shell

定义:
+ Shell shutdown()

参数:
+ 无

返回值:
+ Shell - 返回对象本身方便链式调用

示例代码:
+ 通过 Shell.shutdown() 关闭 Shell
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Shells.newLocalShell() 用于创建一个新的本地 Shell
def shell = $shells.newLocalShell("application")
// Shell.exec() 用于执行命令
def shellResult = shell.exec("echo", ["\$\$"])
// ShellResult.output() 用于获取命令执行时所有的输出信息
$console.log(shellResult.output())
// Shell.shutdown() 用于关闭 Shell
shell.shutdown()