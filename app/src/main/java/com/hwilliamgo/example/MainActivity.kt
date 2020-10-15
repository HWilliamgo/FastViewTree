package com.hwilliamgo.example

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hwilliamgo.fastviewtree.getViewTreeString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.post {
            Log.d(TAG, getViewTreeString())
        }

        val viewTreeInfo = getViewTreeString { v: View ->
            "x= ${v.x}, y=${v.y}"
        }
    }
}
