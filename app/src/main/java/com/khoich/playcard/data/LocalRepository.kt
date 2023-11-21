package com.khoich.playcard.data

import com.khoich.playcard.data.local.dao.MatchDao
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.data.local.model.Player
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val matchDao: MatchDao
) {

}
