package com.khoich.playcard.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoich.playcard.data.local.dao.MatchDao
import com.khoich.playcard.data.local.dao.ScoreDao
import com.khoich.playcard.data.local.model.Game
import com.khoich.playcard.data.local.model.GameScore
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.data.local.model.PlayerGameCrossRef
import com.khoich.playcard.data.local.model.Winner

@Database(
    entities = [Match::class, Game::class, Winner::class, Player::class, PlayerGameCrossRef::class, GameScore::class],
    version = 2,
    exportSchema = false
)

abstract class LocalDatabase: RoomDatabase() {

    abstract fun matchDao(): MatchDao

    abstract fun scoreDao(): ScoreDao
}