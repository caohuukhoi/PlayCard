package com.khoich.playcard.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.khoich.playcard.data.local.model.Game
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.data.local.model.PlayerGameCrossRef

data class PlayerWithGames(
    @Embedded val player: Player,
    @Relation(
        parentColumn = "playerId",
        entityColumn = "gameId",
        associateBy = Junction(PlayerGameCrossRef::class)
    )
    val listGames: List<Game>
)
