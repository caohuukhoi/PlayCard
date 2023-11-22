package com.khoich.playcard.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Player

data class MatchWithPlayers(
    @Embedded val match: Match,
    @Relation(
        parentColumn = "matchId",
        entityColumn = "matchId"
    )
    val listPlayers: List<Player>
)
