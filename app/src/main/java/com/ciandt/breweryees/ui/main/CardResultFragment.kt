package com.ciandt.breweryees.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.Model.fakeCervejaria
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentCardResultBinding
import com.ciandt.breweryees.databinding.FragmentTop10Binding
import kotlinx.android.synthetic.main.fragment_top10.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardResultFragment : Fragment() {
    private var _binding : FragmentCardResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: Top10ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardResultBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRecyclerView.adapter = CervejariaAdapter(fakeCervejaria())
        //setupListeners()
        recyclerViewIndicator.setRecyclerView(topRecyclerView)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}