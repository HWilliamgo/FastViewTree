<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
- [FastViewTree](#fastviewtree)
    - [Download](#download)
    - [Api -> FastViewTree.kt](#api---fastviewtreekt)
      - [公开方法](#公开方法)
      - [自定义信息](#自定义信息)
    - [效果](#效果)
    - [开发背景](#开发背景)
    - [SDK包分发](#sdk包分发)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

![carbon](https://s1.ax1x.com/2020/05/05/Yil2NV.png)

# FastViewTree

![](https://img.shields.io/badge/language-Kotlin-blueviolet.svg)



`FastViewTree` is a Kotlin written android lib which provides the ability to fetch the view tree information during runtime. 

`FastViewTree` gives you another option during debugging some complex UI issue.

`FastViewTree` comes with not only view tree info but also size and visibility info of the view.

The coordinates info of view is not yet included but is in the plan.


### Download

``` kotlin
// 仓库配置
allprojects {
    repositories {
        maven("https://gitee.com/HWilliamgo/maven-repository/raw/SNAPSHOT")
    }
}
// 依赖配置
implementation ("com.hwilliamgo:fastviewtree:1.0.6")
```



### Api -> FastViewTree.kt



#### 公开方法

| function                    | explain                |
| --------------------------- | ---------------------- |
| View?.getViewTreeString     | 获取该View的view树信息，以字符串返回 |
| Activity?.getViewTreeString | 获取该Activity的view树信息，以字符串返回 |
| Activity.createButtonToPrint| 在Activity左上角创建一个按钮，点击后在回调中返回view树字符串|



#### 自定义信息

FastViewTree提供了回调的形式来为每个遍历到的View添加额外的你可以自定义的信息，例如：

``` kotlin
val viewTreeInfo=getViewTreeString {v:View-> 
    "x=${v.x}, y=${v.y}"
}
```



### 效果

```
├──[ContentFrameLayout] android:id/content   width=1080, height=2082  visibility=VISIBLE
└──[ConstraintLayout] no id   width=1080, height=2082  visibility=VISIBLE
   ├──[AppCompatTextView] com.hwilliamgo.fastviewtree:id/tv   width=225, height=57  visibility=VISIBLE
   └──[LinearLayout] no id   width=264, height=144  visibility=VISIBLE
      ├──[AppCompatButton] no id   width=0, height=0  visibility=GONE
      └──[AppCompatButton] no id   width=264, height=144  visibility=VISIBLE
```



### 开发背景

[Android调试View工具-md](https://hwilliamgo.github.io/2020/05/05/个人开源项目/Android调试View工具-md/)

### SDK包分发

使用当前gradle官网最新的maven-publish插件。

[Gradle Maven Publish Plugin](https://docs.gradle.org/current/userguide/publishing_maven.html)

[Android开发者：使用 Maven Publish 插件](https://developer.android.google.cn/studio/build/maven-publish-plugin?hl=zh-cn)