package com.khoich.playcard.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Winner(
    @PrimaryKey(autoGenerate = false)
    val winnerName: String,
    val matchId: Long
)