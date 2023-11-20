package com.khoich.playcard.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khoich.playcard.di.viewmodel.ViewModelFactory
import com.khoich.playcard.di.viewmodel.ViewModelKey
import com.khoich.playcard.ui.entermatch.EnterMatchViewModel
import com.khoich.playcard.ui.home.HomeViewModel
import com.khoich.playcard.ui.main.MainViewModel
import com.khoich.playcard.ui.splash.SplashViewModel

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
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EnterMatchViewModel::class)
    internal abstract fun enterMatchViewModel(viewModel: EnterMatchViewModel): ViewModel

}