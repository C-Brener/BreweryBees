package com.ciandt.breweryees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.CervejariaModel

class CervejariaAdapter(val cervejarias : MutableList<CervejariaModel>) : RecyclerView.Adapter<CervejariaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CervejariaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_item, parent, false)

        return CervejariaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CervejariaViewHolder, position: Int) {
        holder.bind(cervejarias[position])
    }

    override fun getItemCount(): Int = cervejarias.size

}