package com.khoich.playcard.data

import com.khoich.playcard.data.local.dao.MatchDao
import com.khoich.playcard.data.local.dao.ScoreDao
import com.khoich.playcard.data.local.model.GameScore
import com.khoich.playcard.data.local.model.relations.MatchWithPlayers
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val matchDao: MatchDao,
    private val scoreDao: ScoreDao
) {
    suspend fun insertMatchWithPlayers(matchWithPlayers: MatchWithPlayers) {
        matchDao.insertMatchWithPlayers(matchWithPlayers)
    }
    suspend fun getAllMatchWithPlayers(): List<MatchWithPlayers>{
        return matchDao.getAllMatchWithPlayer()
    }

    ///////////////////////
    suspend fun insertGame(gameScore: GameScore){
        scoreDao.insertGame(gameScore)
    }

    suspend fun updateGame(gameScore: GameScore){
        scoreDao.updateGame(gameScore)
    }

    suspend fun deleteGame(gameScore: GameScore){
        scoreDao.deleteGame(gameScore)
    }

    suspend fun getAllGameASC(): List<GameScore>{
        return scoreDao.getAllGameASC()
    }
    suspend fun getAllGameDESC(): List<GameScore>{
        return scoreDao.getAllGameDESC()
    }

}
