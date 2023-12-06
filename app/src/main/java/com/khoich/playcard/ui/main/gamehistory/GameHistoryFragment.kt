package com.khoich.playcard.ui.main.gamehistory

import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentGameHistoryBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.showBottomNavigationView

class GameHistoryFragment : BaseFragment<FragmentGameHistoryBinding, GameHistoryViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_game_history

    override fun viewModelClass(): Class<GameHistoryViewModel> = GameHistoryViewModel::class.java

    override fun initView() {
    }

    override fun onResume() {
        super.onResume()
        showBottomNavigationView()
    }
}