package com.ciandt.breweryees.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.databinding.CardOpinionHorizontalBinding
import com.ciandt.breweryees.databinding.FragmentResultBinding

class ResultListViewHolder(private val binding: CardOpinionHorizontalBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(breweriesModel: BreweriesModel) = with(binding.root){
        binding.barName.text = breweriesModel.name.toString()
        binding.opinionNote.text = breweriesModel.average.toString()
    }
}
