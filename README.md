<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [FastViewTree](#fastviewtree)
    - [Download](#download)
    - [Api -> FastViewTree.kt](#api---fastviewtreekt)
      - [公开方法](#%E5%85%AC%E5%BC%80%E6%96%B9%E6%B3%95)
      - [自定义信息](#%E8%87%AA%E5%AE%9A%E4%B9%89%E4%BF%A1%E6%81%AF)
    - [效果](#%E6%95%88%E6%9E%9C)
    - [开发背景](#%E5%BC%80%E5%8F%91%E8%83%8C%E6%99%AF)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

![carbon](https://s1.ax1x.com/2020/05/05/Yil2NV.png)

# FastViewTree

![](https://img.shields.io/badge/language-Kotlin-blueviolet.svg)  [![Download](https://api.bintray.com/packages/huangwilliam33333/maven/fastviewtree/images/download.svg?version=1.0.5)](https://bintray.com/huangwilliam33333/maven/fastviewtree/1.0.5/link) 



`FastViewTree` is a Kotlin written android lib which provides the ability to fetch the view tree information during runtime. 

`FastViewTree` gives you another option during debugging some complex UI issue.

`FastViewTree` comes with not only view tree info but also size and visibility info of the view.

The coordinates info of view is not yet included but is in the plan.


### Download

``` groovy
implementation ("com.hwilliamgo:fastviewtree:1.0.5")
```



### Api -> FastViewTree.kt



#### 公开方法

| function                    | explain                |
| --------------------------- | ---------------------- |
| View?.getViewTreeString     | 获取该View的view树信息，以字符串返回 |
| Activity?.getViewTreeString | 获取该Activity的view树信息，以字符串返回 |



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
