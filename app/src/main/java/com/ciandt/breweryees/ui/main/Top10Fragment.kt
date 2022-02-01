package com.ciandt.breweryees.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.databinding.FragmentTop10Binding
import kotlinx.android.synthetic.main.fragment_top10.*

class Top10Fragment : Fragment() {

    private var _binding : FragmentTop10Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: Top10ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTop10Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //topRecyclerView.adapter = CervejariaAdapter(fakeCervejaria())
        //setupListeners()
        recyclerViewIndicator.setRecyclerView(topRecyclerView)
    }

    fun setupListeners(){
        viewModel.bearListLiveData.observe(viewLifecycleOwner) { beerList ->
            CervejariaAdapter(beerList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}