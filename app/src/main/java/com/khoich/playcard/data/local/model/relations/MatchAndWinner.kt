package com.khoich.playcard.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Winner

data class MatchAndWinner (
    @Embedded val match: Match,
    @Relation(
        parentColumn = "matchId",
        entityColumn = "matchId"
    )
    val winner: Winner
)