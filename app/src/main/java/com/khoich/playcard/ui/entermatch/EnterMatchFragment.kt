package com.khoich.playcard.ui.entermatch

import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.widget.doAfterTextChanged
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentEnterMatchBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.ui.main.MainActivity
import com.khoich.playcard.util.listener.setOnSingleClickListener
import com.khoich.playcard.util.showSoftKeyboard


class EnterMatchFragment : BaseFragment<FragmentEnterMatchBinding, EnterMatchViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_enter_match
    override fun viewModelClass(): Class<EnterMatchViewModel> = EnterMatchViewModel::class.java

    override fun initView() {
        binding.btnNumberPlayer.setOnSingleClickListener {
            showPopup(it)
        }
        binding.edt1.doAfterTextChanged {
            showSoftKeyboard(activity as MainActivity)
        }
        binding.btnNameGame.setOnSingleClickListener {
            showSoftKeyboard(activity as MainActivity)
        }
    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(requireContext(), v)
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item2player -> {
                    val text = "2"
                    binding.btnNumberPlayer.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item3player -> {
                    val text = "3"
                    binding.btnNumberPlayer.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item4player -> {
                    val text = "4"
                    binding.btnNumberPlayer.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item5player -> {
                    val text = "5"
                    binding.btnNumberPlayer.text = text
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }
        popup.inflate(R.menu.popup_menu)
        popup.show()
    }
}