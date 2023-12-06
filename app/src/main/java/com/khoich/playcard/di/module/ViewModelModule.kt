package com.khoich.playcard.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khoich.playcard.di.viewmodel.ViewModelFactory
import com.khoich.playcard.di.viewmodel.ViewModelKey
import com.khoich.playcard.ui.matchinput.MatchInputViewModel
import com.khoich.playcard.ui.main.home.HomeViewModel
import com.khoich.playcard.ui.main.MainViewModel
import com.khoich.playcard.ui.gameplay.GamePlayViewModel
import com.khoich.playcard.ui.main.gamehistory.GameHistoryViewModel
import com.khoich.playcard.ui.main.playerinfo.PlayerInfoViewModel
import com.khoich.playcard.ui.main.rules.RulesViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(MatchInputViewModel::class)
    internal abstract fun matchInputViewModel(viewModel: MatchInputViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(GamePlayViewModel::class)
    internal abstract fun gamePlayViewModel(viewModel: GamePlayViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(GameHistoryViewModel::class)
    internal abstract fun gameHistoryViewModel(viewModel: GameHistoryViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(PlayerInfoViewModel::class)
    internal abstract fun playerInfoViewModel(viewModel: PlayerInfoViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(RulesViewModel::class)
    internal abstract fun rulesViewModel(viewModel: RulesViewModel): ViewModel

}