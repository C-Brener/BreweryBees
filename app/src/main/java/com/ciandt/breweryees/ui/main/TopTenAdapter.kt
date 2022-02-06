package com.ciandt.breweryees.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.R

class TopTenAdapter(private val breweriesList: List<BreweriesModel>) : RecyclerView.Adapter<TopTenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTenViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_ten_item, parent, false)

        return TopTenViewHolder(view)
    }

    override fun onBindViewHolder(holderTopTen: TopTenViewHolder, position: Int) {
        holderTopTen.bind(breweriesList[position])
    }

    override fun getItemCount(): Int = breweriesList.size
}