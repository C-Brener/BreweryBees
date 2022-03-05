package com.ciandt.breweryees.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityRatedBreweriesBinding
import com.ciandt.breweryees.ui.ratedBreweries.ResultRatedFragment
import com.ciandt.breweryees.ui.ratedBreweries.initRatedBreweriesFragment
import org.koin.androidx.fragment.android.replace

class RatedBreweries : AppCompatActivity() {

    private lateinit var binding: ActivityRatedBreweriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatedBreweriesBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val emailFragment = supportFragmentManager.findFragmentByTag("containerFragment") as initRatedBreweriesFragment

        emailFragment.emailListener = { email ->
            supportFragmentManager.commit {
                val args = Bundle().apply {
                    putString("inputEmail", email)
                }
                    replace<ResultRatedFragment>(R.id.containerFragment, args)

            }
        }

    }
}