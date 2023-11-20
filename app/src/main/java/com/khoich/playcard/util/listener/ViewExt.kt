package com.khoich.playcard.util.listener

import android.view.View

fun View.setOnSingleClickListener(onClick: (View) -> Unit) {
    setOnClickListener(object : OnSingleClickListener() {
        override fun onSingleClick(view: View) {
            onClick.invoke(view)
        }
    })
}