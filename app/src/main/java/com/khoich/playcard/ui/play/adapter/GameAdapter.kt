package com.khoich.playcard.ui.play.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khoich.playcard.data.local.model.GameScore
import com.khoich.playcard.databinding.ItemGameBinding
import com.khoich.playcard.util.listener.setOnSingleClickListener

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    inner class GameViewHolder constructor(val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameScore: GameScore?) {
            binding.tvNumerical.text = gameScore?.gameScoreId.toString()
            binding.tvScoreGame1.text = gameScore?.score1.toString()
            binding.tvScoreGame2.text = gameScore?.score2.toString()
            binding.tvScoreGame3.text = gameScore?.score3.toString()
            binding.tvScoreGame4.text = gameScore?.score4.toString()
            binding.tvScoreGame5.text = gameScore?.score5.toString()
        }
    }

    var listGame: List<GameScore>? = null

    var onItemClick: ((GameScore?) -> Unit)? = null

    var onDeleteClick: ((GameScore?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int = listGame?.size ?: 0

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(listGame?.get(position))
        holder.itemView.setOnSingleClickListener {
            onDeleteClick?.invoke(listGame?.get(position))
        }
    }
}