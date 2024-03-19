package sample.加解密.Crypto

/*
功能:
+ 加密数据.

定义:
+ byte[] decrypt(String algorithm, byte[] data, byte[] key)

参数:
+ String algorithm - 加密算法,例如 RSA,AES,DES,DESede
+ byte[] data - 需要加密的二进制数据
+ byte[] key - 密钥

返回值:
+ byte[] - 加密后的数据,加密失败会返回null

示例代码:
+ 通过 Crypto.encrypt() 加密数据.
 */
// Floaty.showConsoleWindow() 用于显示控制台悬浮窗口
$floaty.showConsoleWindow()

// RSA 加解密例子
// Strings.toBytes() 用于将字符串转成字节数组
def data = $strings.toBytes('RSA')
// Crypto.newKeyPair() 用于生成密钥对
def keyPair = $crypto.newKeyPair('RSA', 2048)
// KeyPair.publicKey() 用于获取公钥
def publicKey = keyPair.publicKey()
// Crypto.encrypt() 用于加密数据
def encryptedData = $crypto.encrypt('RSA', data, publicKey.encoded())
// KeyPair.privateKey() 用于获取私钥
def privateKey = keyPair.privateKey()
// Crypto.decrypt() 用于解密数据
def decryptedData = $crypto.decrypt('RSA', encryptedData, privateKey.encoded())
$assert.assertTrue($strings.fromBytes(decryptedData) == 'RSA', 'RSA')

// // DES 加解密例子
// // Crypto.newKey() 用于新建密钥
// def key = $crypto.newKey('DES', 56)
// // Strings.toBytes() 用于将字符串转成字节数组
// def data = $strings.toBytes('DES')
// // Crypto.encrypt() 用于加密数据
// def encryptedData = $crypto.encrypt('DES', data, key.encoded())
// // Crypto.decrypt() 用于解密数据
// def decryptedData = $crypto.decrypt('DES', encryptedData, key.encoded())
// $assert.assertTrue($strings.fromBytes(decryptedData) == 'DES', 'DES')

// // AES 加解密例子
// // Crypto.newKey() 用于新建密钥
// def key = $crypto.newKey('AES', 128)
// // Strings.toBytes() 用于将字符串转成字节数组
// def data = $strings.toBytes('AES')
// // Crypto.encrypt() 用于加密数据
// def encryptedData = $crypto.encrypt('AES', data, key.encoded())
// // Crypto.decrypt() 用于解密数据
// def decryptedData = $crypto.decrypt('AES', encryptedData, key.encoded())
// $assert.assertTrue($strings.fromBytes(decryptedData) == 'AES', 'AES')

//  // 3DES 加解密例子
//  // Crypto.newKey() 用于新建密钥
//  def key = $crypto.newKey('DESede', 168)
//  // Strings.toBytes() 用于将字符串转成字节数组
//  def data = $strings.toBytes('3DES')
//  // Crypto.encrypt() 用于加密数据
//  def encryptedData = $crypto.encrypt('DESede', data, key.encoded())
//  // Crypto.decrypt() 用于解密数据
//  def decryptedData = $crypto.decrypt('DESede', encryptedData, key.encoded())
//  $assert.assertTrue($strings.fromBytes(decryptedData) == '3DES', '3DES')
