package com.khoich.playcard.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khoich.playcard.R
import com.khoich.playcard.databinding.ActivityMainBinding
import com.khoich.playcard.ui.base.BaseActivity

class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>(){
    override fun layoutRes(): Int = R.layout.activity_main

    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initView() {

    }

}