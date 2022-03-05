package com.ciandt.breweryees.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentErrorResultsBinding
import com.ciandt.breweryees.databinding.FragmentResultBinding
import com.ciandt.breweryees.ui.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class ResultFragment : Fragment() {
    private var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ResultViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments

        viewModel.searchListLiveData.observe(this.viewLifecycleOwner){ list ->
                binding.topRecyclerView.adapter = ResultListAdapter(list)
        }
        bundle?.getString("searchCity").toString().apply {
            viewModel.getSearchList(this)
        }
        viewModel.searchListErrorLiveData.observe(this.viewLifecycleOwner){
            binding.tryAgain.visibility = View.VISIBLE
            binding.errorSearch.visibility = View.VISIBLE
            binding.containerRecycler.visibility = View.GONE

        }

    }
}