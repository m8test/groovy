package sample.数据库.Databases

/*
功能:
+ 打开/创建数据库,如果数据库存在则打开,否则创建后再打开.

定义:
+ Database openOrCreateDatabase(String path)

参数:
+ String path - 数据库路径,为了防止被其他脚本使用,可以添加前缀或者后缀来防止重复.

返回值:
+ Database - 数据库对象,可用于对数据库进行操作

示例代码:
+ 通过 Databases.openOrCreateDatabase() 打开/创建数据库.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Databases.openOrCreateDatabase() 用于打开/创建数据库
def database = $databases.openOrCreateDatabase("M8Test_test.db")
// Database.createTable() 用于新建一个简单数据表,该表所有列均为text类型,并且存在自增id属性
database.createTable("user", ["username", "password"])
// Database.insert() 用于向数据表中插入数据
database.insert("user", null, ["username": "ZhangSan", "password": "123456"])
// Database.query() 用于查询数据库内容
def data = database.query {
    // delegate -> DatabaseQuery
    // DatabaseQuery.table() 用于设置需要查询的表名
    table("user")
}
$assert.assertTrue(data.length() == 1, "数据大小为1")
def user = data.get(0)
$assert.assertTrue(user.get("username") == "ZhangSan", "用户名")
$assert.assertTrue(user.get("password") == "123456", "密码")
// Databases.dropDatabase() 用于删除数据库
$assert.assertTrue($databases.dropDatabase(database), "删除数据库")