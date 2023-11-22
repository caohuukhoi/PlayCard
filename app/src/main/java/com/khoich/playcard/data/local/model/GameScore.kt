package com.khoich.playcard.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.color.utilities.Score

@Entity
data class GameScore (
    @PrimaryKey(autoGenerate = true)
    val gameScoreId: Long = 0,
    val score1: Int,
    val score2: Int,
    val score3: Int,
    val score4: Int,
    val score5: Int
)