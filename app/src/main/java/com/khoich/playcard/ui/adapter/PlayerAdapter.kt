package com.khoich.playcard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.khoich.playcard.databinding.ItemInputPlayerBinding

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    inner class PlayerViewHolder constructor(val binding: ItemInputPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int?){
                position?.let {
                    val textPlayer = "Người chơi $it"
                    val hintPlayer = "Nhập tên người chơi $it"
                    binding.apply {
                        tvPlayer.text = textPlayer
                        edt.hint = hintPlayer
                    }
                }
            }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    val differ =  AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(ItemInputPlayerBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun getItemCount(): Int = differ.currentList.size
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}