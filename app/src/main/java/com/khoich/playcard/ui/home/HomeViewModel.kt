package com.khoich.playcard.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khoich.playcard.data.LocalRepository
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val localRepository: LocalRepository
): BaseViewModel(){
    var listMatch = MutableLiveData<List<Match>>()
    init {
//        getAllMatches()
    }

//    fun getAllMatches(){
//        viewModelScope.launch (Dispatchers.IO){
//            val data = localRepository.getAllMatches()
//            listMatch.postValue(data)
//        }
//    }
}