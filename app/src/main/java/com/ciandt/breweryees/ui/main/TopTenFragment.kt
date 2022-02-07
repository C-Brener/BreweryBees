package com.ciandt.breweryees.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.databinding.FragmentTopTenBinding

import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.android.synthetic.main.fragment_top_ten.*
import kotlinx.coroutines.*

class TopTenFragment : Fragment() {

    private var _binding : FragmentTopTenBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TopTenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopTenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, TopTenViewModel.TopTenFragmentFactory(BreweriesRepository())).get(TopTenViewModel::class.java)

        viewModel.topTenListLiveData.observe(viewLifecycleOwner){topTenList ->
            topTenRecyclerView.adapter = TopTenAdapter(topTenList)
            topTenViewIndicator.setRecyclerView(topTenRecyclerView)
        }

        viewModel.getTopTenList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}