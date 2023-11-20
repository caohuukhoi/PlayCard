package com.khoich.playcard

import com.khoich.playcard.di.AppComponent
import com.khoich.playcard.di.DaggerAppComponent
import com.squareup.leakcanary.core.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
class BaseApp : DaggerApplication() {

    lateinit var instance: BaseApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        // chỉ khi nào Inject tất cả các ViewModel thì mới import được DaggerAppComponent
        val component: AppComponent = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
        return component
    }
}