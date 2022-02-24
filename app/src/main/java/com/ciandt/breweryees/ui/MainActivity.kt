package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_BreweryBees)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

    }
}


