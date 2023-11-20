package com.khoich.playcard.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentSplashBinding
import com.khoich.playcard.ui.base.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_splash

    override fun viewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }, 1000)
    }

}