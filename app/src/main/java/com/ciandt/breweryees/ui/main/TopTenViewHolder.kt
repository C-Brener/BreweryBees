package com.ciandt.breweryees.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.TopTenItemBinding
import com.squareup.picasso.Picasso

class TopTenViewHolder(private val binding: TopTenItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(breweriesModel: BreweriesModel) = with(binding.root) {

        binding.topItemName.text = breweriesModel.name.toString()
        binding.topItemRating.text = breweriesModel.average.toString()
        binding.topItemType.text = breweriesModel.brewery_type
        binding.topItemDistance.text = breweriesModel.country

        val picaso = Picasso.get()
        var photo: String = ""
        if(breweriesModel.photos!!.isNotEmpty()) {
            photo = breweriesModel.photos?.get(0).toString()
        } else {
            photo = "https://s2.glbimg.com/ASugX-UbRujEdYoO7Pv-CXbfCoU=/smart/e.glbimg.com/og/ed/f/original/2019/10/03/69788743_1408348505985249_4118057545833119744_n.jpg"
        }

        picaso.load(photo)
            .resize(88, 88)
            .centerCrop()
           .error(R.drawable.bar)
            .into(binding.topItemLogo)
    }


}