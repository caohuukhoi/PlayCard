package com.khoich.playcard.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentSplashBinding
import com.khoich.playcard.ui.base.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_splash

    override fun viewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {
    }

}