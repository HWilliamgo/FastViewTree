![carbon](https://s1.ax1x.com/2020/05/05/Yil2NV.png)

# FastViewTree

![](https://img.shields.io/badge/language-Kotlin-blueviolet.svg)  [![Download](https://api.bintray.com/packages/huangwilliam33333/maven/fastviewtree/images/download.svg?version=1.0.4)](https://bintray.com/huangwilliam33333/maven/fastviewtree/1.0.4/link) 





`FastViewTree` is a Kotlin written android lib which provides the ability to fetch the view tree information during runtime. `FastViewTree` gives you another option during debugging some complex UI issue.

`FastViewTree` comes with not only view tree info but also size and visibility info of the view.

The coordinates info of view is not yet included but is on the plan.



FastViewTree是Kotlin编写的android库，它提供了在运行时获取视图树信息的能力。“FastViewTree”在调试一些复杂的UI问题时提供了另一个选项。

FastViewTree不仅提供了视图树信息，还提供了视图的大小和可见性信息。

视图的坐标信息尚未包括在内，但在计划中。



### Download

``` groovy
implementation ("com.hwilliamgo:fastviewtree:1.0.4")
```



### Api -> FastViewTree.kt

| function                    | explain                |
| --------------------------- | ---------------------- |
| View?.getViewTreeString     | 获取该View的view树信息，以字符串返回 |
| Activity?.getViewTreeString | 获取该Activity的view树信息，以字符串返回 |



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

[Android调试View工具-md]([https://hwilliamgo.github.io/2020/05/05/%E4%B8%AA%E4%BA%BA%E5%BC%80%E6%BA%90%E9%A1%B9%E7%9B%AE/Android%E8%B0%83%E8%AF%95View%E5%B7%A5%E5%85%B7-md/](https://hwilliamgo.github.io/2020/05/05/个人开源项目/Android调试View工具-md/))