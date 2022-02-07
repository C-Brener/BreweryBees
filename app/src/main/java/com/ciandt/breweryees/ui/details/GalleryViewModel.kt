package com.ciandt.breweryees.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GalleryViewModel(private val repository: BreweriesRepository): ViewModel() {
    private val breweriesRepository = BreweriesRepository()
    private val _galleryListLiveData = MutableLiveData<List<BreweriesPhotoModel>>()
    val galleryListLiveData = _galleryListLiveData

    fun getGalleryList(search : String){
        CoroutineScope(Dispatchers.Main).launch{
            val photos = withContext(Dispatchers.Default){
                breweriesRepository.getBreweriesPhotos(search)
            }
            _galleryListLiveData.value = photos
        }
    }

    class GalleryFragmentFactory(
        private val repository : BreweriesRepository
        ):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return GalleryViewModel(repository) as T
        }
    }
}