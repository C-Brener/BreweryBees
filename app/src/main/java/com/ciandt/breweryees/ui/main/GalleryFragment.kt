package com.ciandt.breweryees.ui.main

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentGalleryBinding
import com.ciandt.breweryees.databinding.FragmentTopTenBinding
import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_top_ten.*
import kotlinx.coroutines.*

class GalleryFragment : Fragment() {

    private var _binding : FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    //private lateinit var viewModel: TopTenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrieveRespositories()

        galleryViewIndicator.setRecyclerView(galleryRecyclerView)
    }

    private fun retrieveRespositories(){
        val galleryFragmentJob : CompletableJob = Job()

        val errorHandler : CoroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
            AlertDialog.Builder(context).setTitle("Error")
                .setMessage(exception.message)
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }

        val coroutineScope = CoroutineScope(galleryFragmentJob + Dispatchers.Main)
        coroutineScope.launch (errorHandler) {
            val resultList = BreweriesRepository().getBreweriesPhotos("alphabet-city-brewing-co-new-york")
            galleryRecyclerView.adapter = GalleryAdapter(resultList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}