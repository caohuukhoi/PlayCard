package com.khoich.playcard.ui.main.playerinfo

import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentPlayerInfoBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.showBottomNavigationView

class PlayerInfoFragment : BaseFragment<FragmentPlayerInfoBinding, PlayerInfoViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_player_info

    override fun viewModelClass(): Class<PlayerInfoViewModel> = PlayerInfoViewModel::class.java

    override fun initView() {
    }

    override fun onResume() {
        super.onResume()
        showBottomNavigationView()
    }
}