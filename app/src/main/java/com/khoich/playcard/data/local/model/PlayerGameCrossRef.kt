package com.khoich.playcard.data.local.model

import androidx.room.Entity

@Entity(primaryKeys = ["playerId", "gameId"])
data class PlayerGameCrossRef(
    val playerId: Long,
    val gameId: Long,
    val score: Int
)
