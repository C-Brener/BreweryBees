package com.ciandt.breweryees.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.R

class GalleryAdapter(private val galleyList: List<BreweriesPhotoModel>) : RecyclerView.Adapter<GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)

        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holderGallery: GalleryViewHolder, position: Int) {
        holderGallery.bind(galleyList[position])
    }

    override fun getItemCount(): Int = galleyList.size
}