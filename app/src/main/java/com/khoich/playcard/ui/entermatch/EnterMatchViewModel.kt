package com.khoich.playcard.ui.entermatch

import com.khoich.playcard.data.LocalRepository
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.ui.base.BaseViewModel
import javax.inject.Inject

class EnterMatchViewModel @Inject constructor(
    private val localRepository: LocalRepository,
): BaseViewModel(){
    fun saveMatch(listInfoPlayer: ArrayList<Player>) {

    }

}