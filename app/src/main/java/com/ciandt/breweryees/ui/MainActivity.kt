package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_BreweryBees)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

    }
}


