package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)
        setActionBar(binding.myToolbar)

        //setupLinearRecyclerViewHorizontal()
    }

    /*private fun setupLinearRecyclerViewHorizontal() {
        topRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        topRecyclerView.adapter = CervejariaAdapter(fakeCervejaria())
        recyclerViewIndicator.setRecyclerView(topRecyclerView)
    }*/
}