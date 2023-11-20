package com.khoich.playcard.ui.entermatch

import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentEnterMatchBinding
import com.khoich.playcard.ui.base.BaseFragment

class EnterMatchFragment : BaseFragment<FragmentEnterMatchBinding, EnterMatchViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_enter_match
    override fun viewModelClass(): Class<EnterMatchViewModel> = EnterMatchViewModel::class.java

    override fun initView() {

    }

}