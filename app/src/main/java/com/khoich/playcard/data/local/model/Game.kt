package com.khoich.playcard.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    val gameId: Int = 0,
    val score1: Int = 0,
    val score2: Int = 0,
    val score3: Int = 0,
    val score4: Int = 0,
    val score5: Int = 0,
)