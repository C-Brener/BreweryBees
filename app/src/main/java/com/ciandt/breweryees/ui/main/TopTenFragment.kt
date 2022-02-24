package com.ciandt.breweryees.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ciandt.breweryees.databinding.FragmentTopTenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopTenFragment : Fragment() {

    private var _binding : FragmentTopTenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TopTenViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) : View {
        _binding = FragmentTopTenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.topTenList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                binding.topTenRecyclerView.adapter = TopTenAdapter(list)
                binding.topTenViewIndicator.setRecyclerView(binding.topTenRecyclerView)
            }
        }
        viewModel.getTopTenList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}