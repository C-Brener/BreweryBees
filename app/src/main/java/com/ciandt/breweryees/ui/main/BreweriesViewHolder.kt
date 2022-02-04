package com.ciandt.breweryees.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_item.view.*

class BreweriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(breweries: BreweriesModel)=with(itemView) {
        val imgfake = "https://s2.glbimg.com/ASugX-UbRujEdYoO7Pv-CXbfCoU=/smart/e.glbimg.com/og/ed/f/original/2019/10/03/69788743_1408348505985249_4118057545833119744_n.jpg"
        top_item_name.text = breweries.name.toString()
        top_item_rating.text = breweries.average.toString()
        top_item_distance.text = breweries.country

        val picaso = Picasso.get()
        picaso.load(imgfake)
            .resize(140, 120)
            .centerCrop()
            .into(top_item_logo)

    }
}