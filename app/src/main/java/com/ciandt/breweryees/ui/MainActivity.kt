package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.R
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityMainBinding
import com.ciandt.breweryees.ui.main.ResultFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_BreweryBees)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchBar.clearFocus()
                viewSearch(query!!)
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
//                binding.searchBar.clearFocus()
//                viewSearch(newText!!)
                return false
            }
        })

    }
    fun viewSearch(search:String){
        val fragment = ResultFragment()
        val bundle = Bundle()
        bundle.putString("searchCity",search)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFragment,fragment)
        fragment.arguments = bundle
        transaction.commit()
    }
}