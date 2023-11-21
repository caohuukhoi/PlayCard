package com.khoich.playcard.ui.play

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentPlayBinding
import com.khoich.playcard.ui.base.BaseFragment

class PlayFragment : BaseFragment<FragmentPlayBinding, PlayViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_play

    override fun viewModelClass(): Class<PlayViewModel> = PlayViewModel::class.java

    override fun initView() {

    }

}