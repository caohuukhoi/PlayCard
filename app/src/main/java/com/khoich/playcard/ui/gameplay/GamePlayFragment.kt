package com.khoich.playcard.ui.gameplay

import com.khoich.playcard.R
import com.khoich.playcard.databinding.FragmentGamePlayBinding
import com.khoich.playcard.ui.base.BaseFragment
import com.khoich.playcard.util.hideBottomNavigationView

class GamePlayFragment : BaseFragment<FragmentGamePlayBinding, GamePlayViewModel>(){

    override fun layoutRes(): Int = R.layout.fragment_game_play

    override fun viewModelClass(): Class<GamePlayViewModel> = GamePlayViewModel::class.java

    override fun initView() {
        hideBottomNavigationView()
    }


//    private fun openAddName() {
//        val dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.popup_scanname)
//
//        val window: Window? = dialog.window
//        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val windowAttributes: WindowManager.LayoutParams? = window?.attributes
//        windowAttributes?.gravity = Gravity.CENTER
//        window?.attributes = windowAttributes
//
//        val editName1 = dialog.findViewById<EditText>(R.id.edtName1)
//        val editName2 = dialog.findViewById<EditText>(R.id.edtName2)
//        val editName3 = dialog.findViewById<EditText>(R.id.edtName3)
//        val editName4 = dialog.findViewById<EditText>(R.id.edtName4)
//        val editName5 = dialog.findViewById<EditText>(R.id.edtName5)
//        val tvClose = dialog.findViewById<TextView>(R.id.tvClose)
//        val tvSave = dialog.findViewById<TextView>(R.id.tvSave)
//
//        tvClose.setOnSingleClickListener {
//            dialog.dismiss()
//        }
//
////        tvSave.isEnabled = false
//        tvSave.setOnSingleClickListener {
//            binding.tvPlay1.text = editName1.text.toString().trim()
//            binding.tvPlay2.text = editName2.text.toString().trim()
//            binding.tvPlay3.text = editName3.text.toString().trim()
//            binding.tvPlay4.text = editName4.text.toString().trim()
//            binding.tvPlay5.text = editName5.text.toString().trim()
//            dialog.dismiss()
//        }
//        dialog.show()
//    }

//    private fun openPopUpGame() {
//        val dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.popup_game)
//
//        val window: Window? = dialog.window
//        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val windowAttributes: WindowManager.LayoutParams? = window?.attributes
//        windowAttributes?.gravity = Gravity.CENTER
//        window?.attributes = windowAttributes
//
//        val tvName1 = dialog.findViewById<TextView>(R.id.tvPlayer1)
//        val tvName2 = dialog.findViewById<TextView>(R.id.tvPlayer2)
//        val tvName3 = dialog.findViewById<TextView>(R.id.tvPlayer3)
//        val tvName4 = dialog.findViewById<TextView>(R.id.tvPlayer4)
//        val tvName5 = dialog.findViewById<TextView>(R.id.tvPlayer5)
//
//        val editScore1 = dialog.findViewById<EditText>(R.id.edtScore1)
//        val editScore2 = dialog.findViewById<EditText>(R.id.edtScore2)
//        val editScore3 = dialog.findViewById<EditText>(R.id.edtScore3)
//        val editScore4 = dialog.findViewById<EditText>(R.id.edtScore4)
//        val editScore5 = dialog.findViewById<EditText>(R.id.edtScore5)
//
//        val tvClose = dialog.findViewById<TextView>(R.id.tvClose)
//        val tvSave = dialog.findViewById<TextView>(R.id.tvSave)
//
//        tvName1.text = binding.tvPlay1.text
//        tvName2.text = binding.tvPlay2.text
//        tvName3.text = binding.tvPlay3.text
//        tvName4.text = binding.tvPlay4.text
//        tvName5.text = binding.tvPlay5.text
//
//        tvClose.setOnSingleClickListener {
//            dialog.dismiss()
//        }
//
//        tvSave.setOnSingleClickListener {
//            val game = GameScore(
//                score1 = editScore1.text.toString().toInt(),
//                score2 = editScore2.text.toString().toInt(),
//                score3 = editScore3.text.toString().toInt(),
//                score4 = editScore4.text.toString().toInt(),
//                score5 = editScore5.text.toString().toInt()
//            )
//            viewModel.saveGame(game)
//            viewModel.getAllGameDESC()
//            dialog.dismiss()
//        }
//
//        dialog.show()
//    }
    
}