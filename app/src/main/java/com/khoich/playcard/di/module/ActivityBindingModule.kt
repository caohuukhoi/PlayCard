package com.khoich.playcard.di.module

import com.khoich.playcard.ui.matchinput.MatchInputFragment
import com.khoich.playcard.ui.main.home.HomeFragment
import com.khoich.playcard.ui.main.MainActivity
import com.khoich.playcard.ui.gameplay.GamePlayFragment
import com.khoich.playcard.ui.main.gamehistory.GameHistoryFragment
import com.khoich.playcard.ui.main.playerinfo.PlayerInfoFragment
import com.khoich.playcard.ui.main.rules.RulesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

// trong này chua các hàm abstract trả về của activity và fragment
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    abstract fun bindMatchInputFragment(): MatchInputFragment
    @ContributesAndroidInjector
    abstract fun bindGameHistoryFragment(): GameHistoryFragment
    @ContributesAndroidInjector
    abstract fun bindGamePlayFragment(): GamePlayFragment
    @ContributesAndroidInjector
    abstract fun bindRulesFragment(): RulesFragment
    @ContributesAndroidInjector
    abstract fun bindPlayerInfoFragment(): PlayerInfoFragment
}
