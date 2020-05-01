package com.hwilliamgo.purejava;

import android.view.View;

import com.hwilliamgo.fastviewtree.FastViewTree;

import kotlin.jvm.functions.Function1;

/**
 * date: 2020-04-16
 * author: hwj
 * description:
 */
public class TestJava {
    public static void testForJava(View view) {
        FastViewTree.getViewTreeString(view, true, true, new Function1<View, String>() {
            @Override
            public String invoke(View view) {
                return "";
            }
        });
    }
}
