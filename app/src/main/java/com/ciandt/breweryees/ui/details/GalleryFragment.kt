package com.ciandt.breweryees.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.databinding.FragmentGalleryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {

    private var _binding : FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private val viewModel:GalleryViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getBreweriesPhotos.observe(viewLifecycleOwner){ list->
            binding.galleryRecyclerView.adapter = GalleryAdapter(list)
            binding.galleryViewIndicator.setRecyclerView(binding.galleryRecyclerView)
        }
        val bundle = this.arguments
        bundle?.getString("breweriesId").toString().apply{
            viewModel.getPhotos(this)
        }
    }
}