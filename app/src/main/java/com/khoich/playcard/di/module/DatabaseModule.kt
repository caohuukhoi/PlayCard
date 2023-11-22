package com.khoich.playcard.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.khoich.playcard.data.LocalDatabase

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    // module cấp thấp
    @Singleton
    @Provides
    fun provideDatabase(appContext: Context): LocalDatabase {
        return Room
            .databaseBuilder(
                appContext.applicationContext,
                LocalDatabase::class.java,
                "localDb"
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppPreference(appContext: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(appContext)
    }

    @Singleton
    @Provides
    fun provideMatchDao(db: LocalDatabase) = db.matchDao()

    @Singleton
    @Provides
    fun provideScoreDao(db: LocalDatabase) = db.scoreDao()

}