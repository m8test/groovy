package sample.Shell.Shells

/*
功能:
+ 创建一个新的本地 Shell

定义:
+ Shell newLocalShell(String type)

参数:
+ String type - 本地 Shell 的类型,可选值有 root, adb, application,权限依次降低

返回值:
+ Shell - 根据配置创建的 Shell 对象,如果创建失败返回null

示例代码:
+ 通过 Shells.newLocalShell() 创建一个新的本地 Shell
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Shells.newLocalShell() 用于创建一个新的本地 Shell
def shell = $shells.newLocalShell("application")
// Shell.exec() 用于执行命令
def shellResult = shell.exec("echo", ["\$\$"])
// ShellResult.output() 用于获取命令执行时所有的输出信息
$console.log(shellResult.output())