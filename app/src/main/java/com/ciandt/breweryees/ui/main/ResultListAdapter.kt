package com.ciandt.breweryees.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.databinding.CardOpinionHorizontalBinding
import com.ciandt.breweryees.ui.DetailsActivity

class ResultListAdapter(private val breweryessList : List<BreweriesModel>): RecyclerView.Adapter<ResultListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultListViewHolder {
        return ResultListViewHolder(CardOpinionHorizontalBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    }

    override fun onBindViewHolder(holder: ResultListViewHolder, position: Int) {
        holder.bind(breweryessList[position])

        holder.itemView.setOnClickListener{view ->
            Toast.makeText(view.context, breweryessList[position].id,Toast.LENGTH_LONG).show()

            val intent = Intent(view.context, DetailsActivity::class.java)
            intent.putExtra("breweriesId",breweryessList[position].id)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return breweryessList.size
    }
}