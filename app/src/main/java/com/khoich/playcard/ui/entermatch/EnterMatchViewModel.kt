package com.khoich.playcard.ui.entermatch

import androidx.lifecycle.viewModelScope
import com.khoich.playcard.data.LocalRepository
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.data.local.model.relations.MatchWithPlayers
import com.khoich.playcard.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EnterMatchViewModel @Inject constructor(
    private val localRepository: LocalRepository,
): BaseViewModel(){
    fun saveMatchWithPlayers(matchWithPlayers: MatchWithPlayers) {
        viewModelScope.launch {
            localRepository.insertMatchWithPlayers(matchWithPlayers)
        }
    }

}