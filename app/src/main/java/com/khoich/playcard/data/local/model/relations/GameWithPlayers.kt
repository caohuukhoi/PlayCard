package com.khoich.playcard.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.khoich.playcard.data.local.model.Game
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.data.local.model.PlayerGameCrossRef

data class GameWithPlayers(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "gameId",
        entityColumn = "playerId",
        associateBy = Junction(PlayerGameCrossRef::class)
    )
    val listPlayers: List<Player>
)
