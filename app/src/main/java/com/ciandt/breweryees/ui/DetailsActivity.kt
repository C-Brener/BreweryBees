package com.ciandt.breweryees.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.ViewModel
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityDetailsBinding
import com.ciandt.breweryees.databinding.FragmentModalBinding
import com.ciandt.breweryees.ui.details.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding
    private val viewModel : DetailsViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)

        binding.btnRating.setOnClickListener{

        }

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

    }

    private fun showRatingDialog(){
        val dialog = dialog()
        val sheetBind: FragmentModalBinding = FragmentModalBinding.inflate(layoutInflater)
    }





}