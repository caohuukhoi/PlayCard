package com.khoich.playcard.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khoich.playcard.data.local.model.Match
import com.khoich.playcard.databinding.FragmentPlayBinding
import com.khoich.playcard.databinding.ItemMatchBinding

class MatchAdapter: RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    inner class MatchViewHolder constructor(val binding: ItemMatchBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(match: Match?){
            binding.tvDate
            binding.tvTime
        }
    }

    var matchList: List<Match>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun getItemCount(): Int = matchList?.size ?: 0

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matchList?.get(position))
    }
}