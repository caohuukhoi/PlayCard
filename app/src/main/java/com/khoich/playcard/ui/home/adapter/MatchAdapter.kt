package com.khoich.playcard.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khoich.playcard.data.local.model.relations.MatchWithPlayers
import com.khoich.playcard.databinding.ItemMatchBinding

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    inner class MatchViewHolder constructor(val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(matchWithPlayers: MatchWithPlayers?) {
            matchWithPlayers?.let {
                val listPlayer = it.listPlayers
                val playerCount = listPlayer.size

                binding.clPlay5.visibility = if (playerCount >= 5) View.VISIBLE else View.GONE
                binding.clPlay4.visibility = if (playerCount >= 4) View.VISIBLE else View.GONE
                binding.clPlay3.visibility = if (playerCount >= 3) View.VISIBLE else View.GONE

                val textViewList = listOf(
                    binding.tvPlay1,
                    binding.tvPlay2,
                    binding.tvPlay3,
                    binding.tvPlay4,
                    binding.tvPlay5
                )

                val scoreTextViewList = listOf(
                    binding.tvScore1,
                    binding.tvScore2,
                    binding.tvScore3,
                    binding.tvScore4,
                    binding.tvScore5
                )

                textViewList.take(playerCount).forEachIndexed { index, textView ->
                    textView.text = listPlayer[index].playerName
                }

                scoreTextViewList.take(playerCount).forEachIndexed { index, textView ->
                    textView.text = listPlayer[index].playerScore.toString().trim()
                }
            }
        }
    }

    var listMatch: List<MatchWithPlayers>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun getItemCount(): Int = listMatch?.size ?: 0

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(listMatch?.get(position))
    }
}