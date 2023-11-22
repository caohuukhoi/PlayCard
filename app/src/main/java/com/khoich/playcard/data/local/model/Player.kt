package com.khoich.playcard.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Player(
    @PrimaryKey(autoGenerate = true)
    val playerId: Long = 0,
    val playerName: String,
    val playerImage: Int,
    val playerScore: Int,
    val matchId: Long
)