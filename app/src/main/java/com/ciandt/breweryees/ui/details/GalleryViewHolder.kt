package com.ciandt.breweryees.ui.details

import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.GalleryItemBinding
import com.squareup.picasso.Picasso

class GalleryViewHolder(private val binding:GalleryItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(gallery: BreweriesPhotoModel) = with(binding.root) {
        val picaso = Picasso.get()
        picaso.load(gallery.url)
            .resize(88, 88)
            .centerCrop()
               .error(R.drawable.ic_error)
            .into(binding.galleryItemImg)
    }
}