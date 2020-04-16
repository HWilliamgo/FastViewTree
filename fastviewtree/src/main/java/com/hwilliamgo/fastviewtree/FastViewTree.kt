@file:JvmName("FastViewTree")

package com.hwilliamgo.fastviewtree

import android.app.Activity
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup


/**
 * date: 2020-04-04
 * author: HWilliamGo
 * description: 打印View tree
 */


/**
 * 获取该View的view树信息，以字符串返回
 * [extraInfoCallback] : 额外拼接的信息
 */
@JvmOverloads
fun View?.getViewTreeString(
    withWidthAndHeightInfo: Boolean = true,
    withVisibilityInfo: Boolean = true,
    extraInfoCallback: ((v: View) -> String)? = null
): String {
    if (this == null) {
        return "null"
    }
    val innerExtraInfoCallback: ((v: View) -> String)? = { v ->
        val sb = StringBuilder()
        //宽高信息
        if (withWidthAndHeightInfo) {
            sb.append("width=${v.width}, height=${v.height} ")
        }
        //可见性信息
        if (withVisibilityInfo) {
            val visibility =
                when (this.visibility) {
                    View.VISIBLE -> "VISIBLE"
                    View.INVISIBLE -> "INVISIBLE"
                    View.GONE -> "GONE"
                    else -> "UNKNOWN"
                }
            sb.append(" visibility=$visibility")
        }
        extraInfoCallback?.let {
            sb.append(it.invoke(v))
        }
        sb.toString()
    }
    return getViewHierarchy(this, innerExtraInfoCallback)
}


/**
 * 获取该Activity的view树信息，以字符串返回
 *[extraInfoCallback] : 额外拼接的信息
 */
@JvmOverloads
fun Activity?.getViewTreeString(
    withWidthAndHeightInfo: Boolean = true,
    withVisibilityInfo: Boolean = true, extraInfoCallback: ((v: View) -> String)? = null
): String {
    if (this == null) {
        return "null"
    }
    return findViewById<View>(android.R.id.content).getViewTreeString(
        withWidthAndHeightInfo,
        withVisibilityInfo,
        extraInfoCallback
    )
}


// <editor-fold defaultstate="collapsed" desc="私有">
private fun getViewHierarchy(v: View, extraInfoCallback: ((v: View) -> String)? = null): String {
    val desc = StringBuilder()
    desc.append("\n")
    getViewHierarchy(v, desc, 0, extraInfoCallback)
    return desc.toString()
}

private fun getViewHierarchy(
    v: View,
    desc: StringBuilder,
    margin: Int,
    extraInfoCallback: ((v: View) -> String)? = null
) {
    var marginVar = margin
    desc.append(getViewMessage(v, marginVar, extraInfoCallback))
    if (v is ViewGroup) {
        marginVar++
        for (i in 0 until v.childCount) {
            getViewHierarchy(v.getChildAt(i), desc, marginVar, extraInfoCallback)
        }
    }
}

private fun getViewMessage(
    v: View,
    marginOffset: Int,
    extraInfoCallback: ((v: View) -> String)? = null
): String? {
    val sb = StringBuilder()
    for (i in 0..marginOffset) {
        sb.append("   ")
    }
    if (isViewLastChild(v)) {
        sb.append("└──")
    } else {
        sb.append("├──")
    }
    val marginByBlank = sb.toString()


    val resourceId = v.resources?.let { res ->
        v.id.let { id ->
            if (id > 0) {
                try {
                    res.getResourceName(id)
                } catch (e: Resources.NotFoundException) {
                    "id not exist"
                }
            } else {
                "no id"
            }
        }
    } ?: "null resources"
    return if (extraInfoCallback != null) {
        "$marginByBlank[${v.javaClass.simpleName}] $resourceId   ${extraInfoCallback.invoke(
            v
        )}\n"
    } else {
        "$marginByBlank[${v.javaClass.simpleName}] $resourceId\n"
    }
}

private fun isViewLastChild(v: View): Boolean {
    val parent = (v.parent as ViewGroup)
    return parent.indexOfChild(v) == parent.childCount - 1
}
// </editor-fold>

//  ├──
//  └──