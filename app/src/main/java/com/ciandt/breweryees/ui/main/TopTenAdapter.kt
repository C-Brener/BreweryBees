package com.ciandt.breweryees.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.databinding.TopTenItemBinding
import com.ciandt.breweryees.ui.DetailsActivity

class TopTenAdapter(private val breweriesModelList: List<BreweriesModel>) : RecyclerView.Adapter<TopTenViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTenViewHolder {
        return TopTenViewHolder(TopTenItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holderTopTen: TopTenViewHolder, position: Int) {
        holderTopTen.bind(breweriesModelList[position])

        holderTopTen.itemView.setOnClickListener{ view ->
            Toast.makeText(view.context, breweriesModelList[position].id, Toast.LENGTH_LONG).show()

            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra("breweriesId", breweriesModelList[position].id)
            view.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = breweriesModelList.size
}