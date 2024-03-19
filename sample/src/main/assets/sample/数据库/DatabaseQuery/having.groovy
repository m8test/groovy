package sample.数据库.DatabaseQuery

/*
功能:
+ 筛选通过 groupBy 分组后的各组数据.

定义:
+ DatabaseQuery having(String having)

参数:
+ String having - having语句

返回值:
+ DatabaseQuery - 返回对象本身,方便链式调用

示例代码:
+ 通过 DatabaseQuery.having() 筛选通过 groupBy 分组后的各组数据.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()
// Databases.openOrCreateDatabase() 用于打开/创建数据库
def database = $databases.openOrCreateDatabase("M8Test_test.db")
// Database.createTable() 用于新建一个简单数据表,该表所有列均为text类型,并且存在自增id属性
database.createTable("user", ["username", "password", "city"])
// Database.insert() 用于向数据表中插入数据
database.insert("user", null, ["username": "ZhangSan", "password": "123456", "city": "广州"])
database.insert("user", null, ["username": "LiSi", "password": "123456", "city": "北京"])
database.insert("user", null, ["username": "WangWu", "password": "123456", "city": "广州"])
// Database.query() 用于查询数据库内容
def data = database.query {
    // delegate -> DatabaseQuery
    // DatabaseQuery.table() 用于设置需要查询的表名
    table("user")
    // DatabaseQuery.columns() 用于设置查询返回的列
    columns(["city", "count(*) as population"])
    // DatabaseQuery.groupBy() 用于设置分组
    groupBy("city")
    // DatabaseQuery.having() 用于筛选通过 groupBy 分组后的各组数据.
    having("population >= 2")
}
$assert.assertTrue(data.length() == 1, "数据大小为1")
def user = data.get(0)
$assert.assertTrue(user.get("city") == "广州", "广州")
$assert.assertTrue(user.getInt("population") == 2, "广州人口")
// Databases.dropDatabase() 用于删除数据库
$assert.assertTrue($databases.dropDatabase(database), "删除数据库")