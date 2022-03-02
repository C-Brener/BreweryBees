package com.ciandt.breweryees.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.R
import androidx.appcompat.widget.SearchView
import com.ciandt.breweryees.databinding.ActivityMainBinding
import com.ciandt.breweryees.ui.rated_breweries
import com.ciandt.breweryees.ui.main.ResultFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    //private val viewModel: MainViewModel by viewModel()

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
//        binding.teste.setOnClickListener {
//            val intent = Intent(this, rated_breweries::class.java)
//            startActivity(intent)
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menutoolbar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.starRated){
            val intent = Intent(this, rated_breweries::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
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