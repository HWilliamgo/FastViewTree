![carbon](https://s1.ax1x.com/2020/05/05/Yil2NV.png)

# FastViewTree

![](https://img.shields.io/badge/language-Kotlin-blueviolet.svg)  [![Download](https://api.bintray.com/packages/huangwilliam33333/maven/fastviewtree/images/download.svg?version=1.0.4)](https://bintray.com/huangwilliam33333/maven/fastviewtree/1.0.4/link) 



`FastViewTree` is a Kotlin written android lib which provides the ability to fetch the view tree information during runtime. 

`FastViewTree` gives you another option during debugging some complex UI issue.

`FastViewTree` comes with not only view tree info but also size and visibility info of the view.

The coordinates info of view is not yet included but is in the plan.


### Download

``` groovy
implementation ("com.hwilliamgo:fastviewtree:1.0.4")
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
