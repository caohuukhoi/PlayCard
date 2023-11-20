package com.khoich.playcard.di.module

import com.khoich.playcard.ui.entermatch.EnterMatchFragment
import com.khoich.playcard.ui.home.HomeFragment
import com.khoich.playcard.ui.main.MainActivity
import com.khoich.playcard.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

// trong này chua các hàm abstract trả về của activity và fragment
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun bindSplashFragment(): SplashFragment
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    abstract fun bindEnterMatchFragment(): EnterMatchFragment

}
