package com.khoich.playcard.ui.entermatch

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.khoich.playcard.R
import com.khoich.playcard.data.local.model.Player
import com.khoich.playcard.databinding.FragmentEnterMatchBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.listener.setOnSingleClickListener


class EnterMatchFragment : BaseFragment<FragmentEnterMatchBinding, EnterMatchViewModel>(){
    override fun layoutRes(): Int = R.layout.fragment_enter_match
    override fun viewModelClass(): Class<EnterMatchViewModel> = EnterMatchViewModel::class.java

    override fun initView() {
        binding.btnNumberPlayer.setOnSingleClickListener {
            showPopupNumberPlayer(it)
        }

        binding.btnNameGame.setOnSingleClickListener {
            showPopupTypeGame(it)
        }

        enterInfo()

        binding.tvSave.setOnSingleClickListener {
            viewModel.saveMatch(listInfoPlayer())
            findNavController().popBackStack()
        }
    }

//    private fun listInfoPlayer(): ArrayList<Player> {
//        val listPlayer = ArrayList<Player>()
//        if(binding.edt1.text.toString().trim().isNotEmpty()){
//            val player = Player(
//                playerName = binding.edt1.text.toString().trim(),
//                playerImage = R.id.img1,
//                playerScore = 0
//            )
//            listPlayer.add(player)
//        }
//        if(binding.edt2.text.toString().trim().isNotEmpty()){
//            val player = Player(
//                playerName = binding.edt2.text.toString().trim(),
//                playerImage = R.id.img2,
//                playerScore = 0
//            )
//            listPlayer.add(player)
//        }
//        if(binding.edt3.text.toString().trim().isNotEmpty()){
//            val player = Player(
//                playerName = binding.edt3.text.toString().trim(),
//                playerImage = R.id.img3,
//                playerScore = 0
//            )
//            listPlayer.add(player)
//        }
//        if(binding.edt4.text.toString().trim().isNotEmpty()){
//            val player = Player(
//                playerName = binding.edt4.text.toString().trim(),
//                playerImage = R.id.img4,
//                playerScore = 0
//            )
//            listPlayer.add(player)
//        }
//        if(binding.edt5.text.toString().trim().isNotEmpty()){
//            val player = Player(
//                playerName = binding.edt5.text.toString().trim(),
//                playerImage = R.id.img5,
//                playerScore = 0
//            )
//            listPlayer.add(player)
//        }
//        return listPlayer
//    }

    private fun listInfoPlayer(): ArrayList<Player> {
        val listPlayer = ArrayList<Player>()

        val editTexts = listOf(binding.edt1, binding.edt2, binding.edt3, binding.edt4, binding.edt5)
        val imageIds = listOf(R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5)

        for ((index, editText) in editTexts.withIndex()) {
            val playerName = editText.text.toString().trim()
            if (playerName.isNotEmpty()) {
                val player = Player(
                    playerName = playerName,
                    playerImage = imageIds[index],
                    playerScore = 0
                )
                listPlayer.add(player)
            }
        }

        return listPlayer
    }

    private fun enterInfo() {
        binding.tvSave.isEnabled = false
        binding.edt1.doAfterTextChanged {
            setStateSaveButton(isCheckSave())
        }
        binding.edt2.doAfterTextChanged {
            setStateSaveButton(isCheckSave())
        }
        binding.edt3.doAfterTextChanged {
            setStateSaveButton(isCheckSave())
        }
        binding.edt4.doAfterTextChanged {
            setStateSaveButton(isCheckSave())
        }
        binding.edt5.doAfterTextChanged {
            setStateSaveButton(isCheckSave())
        }
    }

    private fun setStateSaveButton(check: Boolean) {
        if (check) {
            binding.tvSave.setBackgroundResource(R.drawable.shape_save)
            binding.tvSave.setTextColor(Color.WHITE)
        } else {
            binding.tvSave.setBackgroundResource(R.drawable.shape_save_disable)
            binding.tvSave.setTextColor(Color.DKGRAY)
        }
        binding.tvSave.isEnabled = check
    }

//    private fun isCheckSave(): Boolean{
//        val namePlayer1 = binding.edt1.text.toString().trim()
//        val namePlayer2 = binding.edt2.text.toString().trim()
//        val namePlayer3 = binding.edt3.text.toString().trim()
//        val namePlayer4 = binding.edt4.text.toString().trim()
//        val namePlayer5 = binding.edt5.text.toString().trim()
//        return namePlayer1.isNotEmpty() && namePlayer2.isNotEmpty() && namePlayer3.isNotEmpty()
//                && namePlayer4.isNotEmpty() && namePlayer5.isNotEmpty()
//    }
    private fun isCheckSave(): Boolean {
        val playerCount = binding.btnNumberPlayer.text.toString().toIntOrNull() ?: 0

        val editTexts = listOf(binding.edt1, binding.edt2, binding.edt3, binding.edt4, binding.edt5)
            .take(playerCount) // Chỉ lấy số lượng EditText tương ứng với số người chơi

        val nonEmptyCount = editTexts.count {
            it.text.toString().trim().isNotEmpty()
        }

        return nonEmptyCount == playerCount
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
                    updateUIForPlayerCount("2")
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item3player -> {
                    updateUIForPlayerCount("3")
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item4player -> {
                    updateUIForPlayerCount("4")
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                R.id.item5player -> {
                    updateUIForPlayerCount("5")
                    setStateSaveButton(isCheckSave())
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener false
            }
        }

        popup.inflate(R.menu.popup_menu_numberplayer)
        popup.show()
    }

    private fun updateUIForPlayerCount(playerCount: String) {
        binding.btnNumberPlayer.text = playerCount

        binding.rl3.visibility = if (playerCount in listOf( "3", "4", "5")) View.VISIBLE else View.GONE
        binding.rl4.visibility = if (playerCount in listOf( "4", "5")) View.VISIBLE else View.GONE
        binding.rl5.visibility = if (playerCount == "5") View.VISIBLE else View.GONE

        when (playerCount) {
            "2" -> {
                // Ẩn rl3, rl4, rl5 nếu có
                binding.img3.setImageResource(0)
                binding.edt3.text = null

                binding.img4.setImageResource(0)
                binding.edt4.text = null

                binding.img5.setImageResource(0)
                binding.edt5.text = null
            }
            "3" -> {
                // Ẩn rl4, rl5 nếu có
                binding.img4.setImageResource(0)
                binding.edt4.text = null

                binding.img5.setImageResource(0)
                binding.edt5.text = null
            }
            "4" -> {
                // Ẩn rl5 nếu có
                binding.img5.setImageResource(0)
                binding.edt5.text = null
            }
        }
    }


}