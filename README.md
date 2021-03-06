#  Android垃圾代码生成插件

此插件用于做马甲包时，减小马甲包与主包的代码相似度，避免被某些应用市场识别为马甲包。

### 使用方法

根目录的build.gradle中：
```
buildscript {
    repositories {
       maven { url 'https://jitpack.io' }
    }
    dependencies {
        classpath "com.github.lixuce248:InsertCode:1.0.3"
    }
}
```


app目录的build.gradle模块中：
```groovy
apply plugin: 'com.android.application'
apply plugin: 'com.lee.plugin'

androidJunkCode {
    variantConfig {
        release {//变体名称，如果没有设置productFlavors就是buildType名称，如果有设置productFlavors就是flavor+buildType，例如（freeRelease、proRelease）
            packageBase = "com.lee.plugin.ui"  //生成java类根包名
            packageCount = 30 //生成包数量
            activityCountPerPackage = 3 //每个包下生成Activity类数量
            excludeActivityJavaFile = false //是否排除生成Activity的Java文件,默认false(layout和写入AndroidManifest.xml还会执行)，主要用于处理类似神策全埋点编译过慢问题
            otherCountPerPackage = 50  //每个包下生成其它类的数量
            methodCountPerClass = 20  //每个类下生成方法数量
            resPrefix = "insert_"  //生成的layout、drawable、string等资源名前缀
            drawableCount = 300  //生成drawable资源数量
            stringCount = 300  //生成string数量
        }
    }
}
```

如果APP开启了混淆，需要在混淆文件里配置

```
#com.lee.plugin.ui为前面配置的packageBase
-keep class com.lee.plugin.ui.** {*;}
```

### 生成文件所在目录
build/generated/source/junk


