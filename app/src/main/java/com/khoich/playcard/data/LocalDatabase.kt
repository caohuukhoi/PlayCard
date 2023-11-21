package com.khoich.playcard.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoich.playcard.data.local.dao.GameDao
import com.khoich.playcard.data.local.dao.MatchDao
import com.khoich.playcard.data.local.dao.PlayerDao
import com.khoich.playcard.data.local.model.Game
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Player

@Database(
    entities = [Match::class, Player::class, Game::class],
    version = 2,
    exportSchema = false
)

abstract class LocalDatabase: RoomDatabase() {

    abstract fun matchDao(): MatchDao

    abstract fun playerDao(): PlayerDao

    abstract fun gameDao(): GameDao

}