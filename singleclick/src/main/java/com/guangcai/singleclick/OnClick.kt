package com.guangcai.singleclick

import android.view.View

/**
 *created by 胡广才
 *on 2020/7/20
 */
inline fun View.setSingleCLickListener(crossinline action:()->Unit){
    var lastClick=0L
    setOnClickListener {
        val gap = System.currentTimeMillis() - lastClick
        lastClick= System.currentTimeMillis()
        if(gap<1500) return@setOnClickListener
        action.invoke()
    }
}
var _viewClickFlag = false
var _clickRunnable = Runnable { _viewClickFlag = false }
fun View.click(action: (view: View) -> Unit) {
    setOnClickListener {
        if (!_viewClickFlag) {
            _viewClickFlag = true
            action(it)
        }
        removeCallbacks(_clickRunnable)
        postDelayed(_clickRunnable, 1000)
    }
}