package com.ciandt.breweryees

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.ciandt.breweryees.Model.fakeCervejaria
import com.ciandt.breweryees.databinding.ActivityMainBinding
import com.kingfisher.easyviewindicator.AnyViewIndicator
import com.kingfisher.easyviewindicator.RecyclerViewIndicator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var horizontalIndicator: RecyclerViewIndicator? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_Breweryees)
        super.onCreate(savedInstanceState)

        binding = com.ciandt.breweryees.databinding.ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)

        setupLinearRecyclerViewHorizontal()
    }

    private fun setupLinearRecyclerViewHorizontal() {
        topRecyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        topRecyclerView.adapter = CervejariaAdapter(fakeCervejaria())

        topRecyclerView.setLayoutManager(topRecyclerView.layoutManager)

        horizontalIndicator!!.setRecyclerView(topRecyclerView)
    }

}