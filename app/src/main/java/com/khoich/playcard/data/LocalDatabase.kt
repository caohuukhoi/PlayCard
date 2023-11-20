package com.khoich.playcard.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoich.playcard.data.local.dao.MatchDao
import com.khoich.playcard.data.local.model.Match

@Database(
    entities = [Match::class],
    version = 1,
    exportSchema = false
)

abstract class LocalDatabase: RoomDatabase() {

    abstract fun matchDao(): MatchDao

}