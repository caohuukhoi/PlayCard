package com.khoich.playcard.ui.main.rules

import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentRulesBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.showBottomNavigationView

class RulesFragment : BaseFragment<FragmentRulesBinding, RulesViewModel>() {
    override fun layoutRes(): Int = R.layout.fragment_rules

    override fun viewModelClass(): Class<RulesViewModel> = RulesViewModel::class.java

    override fun initView() {
    }
    override fun onResume() {
        super.onResume()
        showBottomNavigationView()
    }
}
