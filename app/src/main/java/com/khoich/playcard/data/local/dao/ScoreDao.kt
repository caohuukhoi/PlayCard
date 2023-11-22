package com.khoich.playcard.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.khoich.playcard.data.local.model.GameScore
import com.khoich.playcard.data.local.model.Match

@Dao
interface ScoreDao {
    @Insert
    suspend fun insertGame(gameScore: GameScore)

    @Query("SELECT * FROM GameScore ORDER BY gameScoreId ASC")
    suspend fun getAllGameASC(): List<GameScore>

    @Query("SELECT * FROM GameScore ORDER BY gameScoreId DESC")
    suspend fun getAllGameDESC(): List<GameScore>

    @Update
    suspend fun updateGame(gameScore: GameScore)

    @Delete
    suspend fun deleteGame(gameScore: GameScore)
}