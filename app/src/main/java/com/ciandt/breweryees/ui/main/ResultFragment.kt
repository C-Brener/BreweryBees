package com.ciandt.breweryees.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : ResultViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ResultViewModel.ResultFragmentFactory()).get(ResultViewModel::class.java)

        viewModel.searchListLiveData.observe(this.viewLifecycleOwner){
            binding.topRecyclerView.adapter = ResultListAdapter(it)

        }
        viewModel.getSearchList("New York")

    }
}