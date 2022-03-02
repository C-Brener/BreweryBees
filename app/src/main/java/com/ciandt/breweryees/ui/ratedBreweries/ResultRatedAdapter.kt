package com.ciandt.breweryees.ui.ratedBreweries

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.databinding.CardOpinionHorizontalBinding
import com.ciandt.breweryees.ui.DetailsActivity

class ResultRatedAdapter(private val breweriesList:List<BreweriesModel>):RecyclerView.Adapter<ResultRatedViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultRatedViewHolder {
        return ResultRatedViewHolder(CardOpinionHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ResultRatedViewHolder, position: Int) {
        holder.bind(breweriesList[position])
        holder.itemView.setOnClickListener{ view->
            Toast.makeText(view.context,breweriesList[position].id, Toast.LENGTH_SHORT).show()

            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra("breweriesId", breweriesList[position].id)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  breweriesList.size
    }

}