# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 设置混淆字典,避免与主包重名
-obfuscationdictionary dictionary.txt
-classobfuscationdictionary dictionary.txt
-packageobfuscationdictionary dictionary.txt
# 不要删除无用代码,因为有些代码是要提供给插件使用的
-dontshrink
# 不要警告
-dontwarn **
# 保留所有第三方库,仅混淆自己写的代码,!表示取反,就是保持不是自己写的代码不变(不被混淆)
-keep class !com.m8test.** {*;}
# 语言类用于提供插件加载,不能混淆,其他类可以混淆
-keep class com.m8test.groovy.GroovyLanguage {*;}
# 保持实体类不被混淆
-keep class com.m8test.groovy.bean.** {*;}
