package com.ciandt.breweryees.ui.ratedBreweries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ciandt.breweryees.databinding.FragmentResultRatedBinding


class ResultRatedFragment : Fragment() {
    private var _binding:FragmentResultRatedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResultRatedViewModel by viewModel()
    var captureSize : ((String) -> Unit?)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments

        viewModel.searchListEvaluationsLiveData.observe(this.viewLifecycleOwner){ list->
            binding.ratedRecyclerView.adapter = ResultRatedAdapter(list)
        }
        bundle?.getString("inputEmail").toString().run {
            viewModel.getSearchListEvaluations(this)
        }

        viewModel.searchListErrorEvaluationsLiveData.observe(this.viewLifecycleOwner){
            binding.titleEmptyRated.visibility = View.VISIBLE
            binding.textEmptyRated.visibility = View.VISIBLE
            binding.containerResult.visibility = View.GONE
        }
    }
}
