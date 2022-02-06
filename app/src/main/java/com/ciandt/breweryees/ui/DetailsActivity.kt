package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ciandt.breweryees.R
import com.ciandt.breweryees.ui.details.GalleryFragment

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val valor = intent.getStringExtra("breweries_id")

        supportFragmentManager.commit {
            val bundle = Bundle()
            bundle.putString("breweries_id",valor)
            add<GalleryFragment>(R.id.detailsFragment,args = bundle)
        }
    }
}