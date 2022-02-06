package com.ciandt.breweryees.ui.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.gallery_item.view.*

class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(gallery: BreweriesPhotoModel) = with(itemView) {
        //galleryText.text = gallery.url
        val picaso = Picasso.get()
        picaso.load(gallery.url)
            .resize(88, 88)
            .centerCrop()
            .error(R.drawable.ic_error)
            .into(gallery_item_img)
    }
}