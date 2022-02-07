package com.ciandt.breweryees.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentGalleryBinding
import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.android.synthetic.main.fragment_gallery.*


class GalleryFragment : Fragment() {

    private var _binding : FragmentGalleryBinding? = null
    //private val binding get() = _binding!!

    private lateinit var viewModel:GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,GalleryViewModel.GalleryFragmentFactory(BreweriesRepository())).get(GalleryViewModel::class.java)

        viewModel.galleryListLiveData.observe(viewLifecycleOwner) { galleryList ->

            galleryRecyclerView.adapter = GalleryAdapter(galleryList)
            galleryViewIndicator.setRecyclerView(galleryRecyclerView)

        }

        val bundle = arguments

        bundle?.getString("breweries_id").toString().apply {
            viewModel.getGalleryList(this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}