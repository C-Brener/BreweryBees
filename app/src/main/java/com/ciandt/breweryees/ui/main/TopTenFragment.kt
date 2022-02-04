package com.ciandt.breweryees.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ciandt.breweryees.databinding.FragmentTopTenBinding

import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.android.synthetic.main.fragment_top_ten.*
import kotlinx.coroutines.*

class TopTenFragment : Fragment() {

    private var _binding : FragmentTopTenBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TopTenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopTenBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrieveRespositories()
        //setupListeners()

        recyclerViewIndicator.setRecyclerView(topRecyclerView)
    }

    fun retrieveRespositories(){
        val top10FragmentJob : CompletableJob = Job()

        val errorHandler : CoroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
            AlertDialog.Builder(context).setTitle("Error")
                .setMessage(exception.message)
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }

        val coroutineScope = CoroutineScope(top10FragmentJob + Dispatchers.Main)
        coroutineScope.launch (errorHandler) {
            val resultList = BreweriesRepository().getBreweriesTopTen()
            topRecyclerView.adapter = TopTenAdapter(resultList)
        }
    }

    fun setupListeners(){
        viewModel.bearListLiveData.observe(viewLifecycleOwner) { beerList ->
            //BreweriesAdapter(beerList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}