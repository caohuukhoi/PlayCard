package com.khoich.playcard.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Player(
    @PrimaryKey(autoGenerate = true)
    val playerId: Int = 0,
    val playerName: String = "",
    val playerImage: Int = 0,
    val playerScore: Int = 0,
)