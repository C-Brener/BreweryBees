package com.ciandt.breweryees.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.databinding.GalleryItemBinding


class GalleryAdapter(private val galleryList: List<BreweriesPhotoModel>) : RecyclerView.Adapter<GalleryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {

        return GalleryViewHolder(
            GalleryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holderGallery: GalleryViewHolder, position: Int) {
        holderGallery.bind(galleryList[position])
    }

    override fun getItemCount(): Int = galleryList.size

}