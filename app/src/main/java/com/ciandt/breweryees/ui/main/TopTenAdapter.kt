package com.ciandt.breweryees.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.R
import kotlinx.android.synthetic.main.fragment_gallery.*


class TopTenAdapter(private val breweriesList: List<BreweriesModel>) : RecyclerView.Adapter<TopTenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTenViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_ten_item, parent, false)
        return TopTenViewHolder(view)
    }

    override fun onBindViewHolder(holderTopTen: TopTenViewHolder, position: Int) {
        holderTopTen.bind(breweriesList[position])

        holderTopTen.itemView.setOnClickListener{view ->
            Toast.makeText(view.context, breweriesList[position].id,Toast.LENGTH_LONG).show()
            val intent= Intent(view.context,GalleryFragment::class.java)
        }
    }

    override fun getItemCount(): Int = breweriesList.size

}