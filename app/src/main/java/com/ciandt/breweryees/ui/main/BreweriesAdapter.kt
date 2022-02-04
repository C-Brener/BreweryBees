package com.ciandt.breweryees.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesResult
import com.ciandt.breweryees.R

class BreweriesAdapter(private val breweriesList: List<BreweriesModel>) : RecyclerView.Adapter<BreweriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweriesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_item, parent, false)

        return BreweriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreweriesViewHolder, position: Int) {
        holder.bind(breweriesList[position])
    }

    override fun getItemCount(): Int = breweriesList.size

}