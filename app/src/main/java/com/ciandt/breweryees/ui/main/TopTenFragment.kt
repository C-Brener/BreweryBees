package com.ciandt.breweryees.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ciandt.breweryees.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopTenFragment : Fragment() {
    private val viewModel: TopTenViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_ten, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showBreweries.observe(viewLifecycleOwner) {
            Log.e("TopTenFragment", it.toString())
        }
        viewModel.loadTopTen()
    }

}