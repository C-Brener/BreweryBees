package com.ciandt.breweryees.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.breweryees.R
import androidx.appcompat.widget.SearchView
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
        val fragment = dd .ResultFragment()
        val bundle = Bundle()
        bundle.putString("searchCity",search)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFragment,fragment)
        fragment.arguments = bundle
        transaction.commit()
    }
}