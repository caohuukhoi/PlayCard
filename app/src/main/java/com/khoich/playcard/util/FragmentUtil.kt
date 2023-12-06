package com.khoich.playcard.util

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.khoich.playcard.R
import com.khoich.playcard.ui.main.MainActivity

fun Fragment.hideBottomNavigationView() {
    val bottomNavigationView =
        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    bottomNavigationView.visibility = View.GONE
}

fun Fragment.showBottomNavigationView() {
    val bottomNavigationView =
        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    bottomNavigationView.visibility = View.VISIBLE
}