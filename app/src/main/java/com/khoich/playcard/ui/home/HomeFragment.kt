package com.khoich.playcard.ui.home

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentHomeBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.ui.home.adapter.MatchAdapter
import com.khoich.playcard.util.listener.setOnSingleClickListener

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    private val matchAdapter = MatchAdapter()
    override fun layoutRes(): Int = R.layout.fragment_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    @SuppressLint("NotifyDataSetChanged")
    override fun initView() {
        binding.fabAdd.setOnSingleClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_playFragment)
        }
        binding.rcvMatch.adapter = matchAdapter
        viewModel.listMatch.observe(this){
            matchAdapter.listMatch = it
            matchAdapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllMatches()
    }
}