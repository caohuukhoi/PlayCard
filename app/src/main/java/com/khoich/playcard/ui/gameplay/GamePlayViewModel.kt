package com.khoich.playcard.ui.gameplay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoich.playcard.data.local.LocalRepository
import com.khoich.playcard.data.local.model.GameScore
import com.khoich.playcard.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamePlayViewModel @Inject constructor(
    private val localRepository: LocalRepository
): BaseViewModel(){
    var listGame = MutableLiveData<List<GameScore>>()
    init {
        getAllGameDESC()
    }

    fun getAllGameASC() {
        viewModelScope.launch {
            listGame.value = localRepository.getAllGameASC()
        }
    }

    fun getAllGameDESC() {
        viewModelScope.launch {
            listGame.value = localRepository.getAllGameDESC()
        }
    }

    fun deleteGame(gameScore: GameScore?){
        viewModelScope.launch {
            if (gameScore != null) {
                localRepository.deleteGame(gameScore)
                getAllGameASC()
            }
        }
    }

    fun saveGame(gameScore: GameScore) {
        viewModelScope.launch {
            localRepository.insertGame(gameScore)
        }
    }
}