package com.khoich.playcard.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoich.playcard.data.local.LocalRepository
import com.khoich.playcard.data.local.model.relations.MatchWithPlayers
import com.khoich.playcard.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val localRepository: LocalRepository
): BaseViewModel(){
    var listMatch = MutableLiveData<List<MatchWithPlayers>>()
    init {
        getAllMatches()
    }

    fun getAllMatches(){
        viewModelScope.launch {
            listMatch.value = localRepository.getAllMatchWithPlayers()
        }
    }
}