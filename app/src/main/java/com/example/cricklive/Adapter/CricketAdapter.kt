package com.example.cricklive.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cricklive.Model.Data
import com.example.cricklive.databinding.ItemLayoutBinding

class CricketAdapter(private val items:ArrayList<Data>): RecyclerView.Adapter<CricketAdapter.CricketviewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketviewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=ItemLayoutBinding.inflate(inflater,parent,false)
        return CricketviewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: CricketviewHolder, position: Int) {
        var currentitem=items[position]
        holder.bind(currentitem)
    }

    inner class CricketviewHolder(private val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: Data){
            binding.team1Name.text=item.teamInfo.get(0).shortname
            binding.team2Name.text=item.teamInfo.get(1).shortname

            if(item.teamInfo.size==2){
                Glide.with(binding.root.context).load(item.teamInfo.get(0).img).into(binding.team1Flag)
            }


            if(item.teamInfo.size==2){
                Glide.with(binding.root.context).load(item.teamInfo.get(1).img).into(binding.team2Flag)
            }



            binding.matchType.text=item.matchType.toUpperCase()
            binding.placeName.text=item.venue
            binding.matchSummery.text=item.status


            if(item.score.size==1){
                binding.team1Score.text="${item.score.get(0).r}"+"/${item.score.get(0).w}"
                binding.team1Over.text="${item.score.get(0).o}Overs"
            }
            if(item.score.size==2){
                binding.team1Score.text="${item.score.get(0).r}"+"/${item.score.get(0).w}"
                binding.team1Over.text="${item.score.get(0).o}Overs"

                binding.team2Score.text="${item.score.get(1).r}"+"/${item.score.get(1).w}"
                binding.team2Overs.text="${item.score.get(1).o}Overs"
            }

        }
    }

}