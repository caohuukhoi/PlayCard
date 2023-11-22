package com.khoich.playcard.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.khoich.playcard.data.local.model.Game
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.data.local.model.PlayerGameCrossRef
import com.khoich.playcard.data.local.model.Winner
import com.khoich.playcard.data.local.model.relations.MatchAndWinner
import com.khoich.playcard.data.local.model.relations.MatchWithPlayers

@Dao
interface MatchDao {
    @Insert
    suspend fun insertMatch(match: Match)
    @Insert
    suspend fun insertWinner(winner: Winner)
    @Insert
    suspend fun insertPlayer(player: Player)
    @Insert
    suspend fun insertGame(game: Game)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayerGameCrossRef(crossRef: PlayerGameCrossRef)
//    @Transaction
//    @Query("SELECT * FROM `match` WHERE matchId = :matchId")
//    suspend fun getMatchAndWinnerWithMatchId(matchId: Long): List<MatchAndWinner>
//
//    @Transaction
//    @Query("SELECT * FROM `match` WHERE matchId = :matchId")
//    suspend fun getMatchWithPlayer(matchId: Long): List<MatchWithPlayers>
    @Transaction
    @Query("SELECT * FROM `match`")
    suspend fun getAllMatchWithPlayer(): List<MatchWithPlayers>

    @Transaction
    suspend fun insertMatchWithPlayers(matchWithPlayers: MatchWithPlayers) {
        insertMatch(matchWithPlayers.match)
        for (player in matchWithPlayers.listPlayers) {
            insertPlayer(player)

        }
    }
}

