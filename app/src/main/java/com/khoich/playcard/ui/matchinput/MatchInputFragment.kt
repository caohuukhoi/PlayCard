package com.khoich.playcard.ui.matchinput

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentMatchInputBinding
import com.khoich.playcard.ui.adapter.PlayerAdapter
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.hideBottomNavigationView
import com.khoich.playcard.util.listener.setOnSingleClickListener


class MatchInputFragment : BaseFragment<FragmentMatchInputBinding, MatchInputViewModel>() {

    private val playerAdapter = PlayerAdapter()
    private var currentPlayerCount: Int = 4
    override fun layoutRes(): Int = R.layout.fragment_match_input
    override fun viewModelClass(): Class<MatchInputViewModel> = MatchInputViewModel::class.java
    override fun initView() {
        hideBottomNavigationView()
        binding.apply {
            rvPlayer.adapter = playerAdapter

            btnNameGame.setOnSingleClickListener {
                showPopupTypeGame(it)
            }

            btnNumberPlayer.setOnSingleClickListener {
                showPopupNumberPlayer(it)
            }

            tvSave.setOnSingleClickListener {
                findNavController().navigate(R.id.action_matchInputFragment_to_gamePlayFragment)
            }
        }
        enterInfo()
    }

    private fun showPopupTypeGame(v: View) {
        val popup = PopupMenu(requireContext(), v)
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_sam -> {
                    val text = "Sâm"
                    binding.btnNameGame.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item_tala -> {
                    val text = "Tá lả"
                    binding.btnNameGame.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item_bac -> {
                    val text = "Tiến lên miền Bắc"
                    binding.btnNameGame.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item_nam -> {
                    val text = "Tiến lên miền Nam"
                    binding.btnNameGame.text = text
                    return@setOnMenuItemClickListener true
                }

                R.id.item_3cay -> {
                    val text = "3 cây"
                    binding.btnNameGame.text = text
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }
        popup.inflate(R.menu.popup_menu_typegame)
        popup.show()
    }

    private fun showPopupNumberPlayer(v: View) {
        val popup = PopupMenu(requireContext(), v)

        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item2player -> {
                    updateUIForPlayerCount(2)
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item3player -> {
                    updateUIForPlayerCount(3)
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item4player -> {
                    updateUIForPlayerCount(4)
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item5player -> {
                    updateUIForPlayerCount(5)
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }

        popup.inflate(R.menu.popup_menu_numberplayer)
        popup.show()
    }

    private fun updateUIForPlayerCount(count: Int) {
        currentPlayerCount = count
        binding.btnNumberPlayer.text = count.toString()

        // Update the dataset with the new player count
        val playerList = (1..count).toList()
        playerAdapter.differ.submitList(playerList)
    }

    private fun setStateSaveButton(check: Boolean) {
        if (check) {
            binding.tvSave.apply {
                setBackgroundResource(R.drawable.shape_save)
                setTextColor(Color.WHITE)
            }
        } else {
            binding.tvSave.apply {
                setBackgroundResource(R.drawable.shape_save_disable)
                setTextColor(Color.DKGRAY)
            }
        }
        binding.tvSave.isEnabled = check
    }

    private fun isCheckSave(): Boolean {
        val playerList = playerAdapter.differ.currentList

        for (position in playerList) {
            val viewHolder =
                binding.rvPlayer.findViewHolderForAdapterPosition(position) as? PlayerAdapter.PlayerViewHolder
            val playerName = viewHolder?.binding?.edt?.text?.toString()

            // Check if playerName is null or empty
            if (playerName.isNullOrBlank()) return false
        }

        // All players have entered names
        return true
    }

    private fun enterInfo() {
        binding.tvSave.isEnabled = false
        val playerList = playerAdapter.differ.currentList

        for (position in playerList) {
            val viewHolder =
                binding.rvPlayer.findViewHolderForAdapterPosition(position) as? PlayerAdapter.PlayerViewHolder
            viewHolder?.binding?.edt?.doAfterTextChanged {
                setStateSaveButton(isCheckSave())
            }
        }
    }

}