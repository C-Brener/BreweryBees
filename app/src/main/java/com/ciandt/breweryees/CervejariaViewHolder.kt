package com.ciandt.breweryees

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.CervejariaModel
import kotlinx.android.synthetic.main.top_item.view.*

class CervejariaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(cervejaria: CervejariaModel) {

        itemView.top_item_name.text = cervejaria.name
        itemView.top_item_rating.text = cervejaria.rating.toString()
        itemView.top_item_type.text = "Tipo"
        itemView.top_item_distance.text = "${cervejaria.distance} km"
    }
}