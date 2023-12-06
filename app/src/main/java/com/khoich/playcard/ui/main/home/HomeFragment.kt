package com.khoich.playcard.ui.main.home

import androidx.navigation.fragment.findNavController
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentHomeBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.listener.setOnSingleClickListener
import com.khoich.playcard.util.showBottomNavigationView

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    override fun layoutRes(): Int = R.layout.fragment_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun initView() {
        binding.apply {
            fabAdd.setOnSingleClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_matchInputFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        showBottomNavigationView()
    }
}