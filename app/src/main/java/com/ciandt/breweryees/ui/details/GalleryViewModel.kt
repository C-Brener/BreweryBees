package com.ciandt.breweryees.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.Model.BreweriesRatingModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class GalleryViewModel (var repository: BreweriesRespository) : ViewModel() {
  private var _getBreweriesPhotos = MutableLiveData<List<BreweriesPhotoModel>>()
    val getBreweriesPhotoset: LiveData<List<BreweriesPhotoModel>> = _getBreweriesPhotos

    public fun getPhotos(breweriesId:String){
        viewModelScope.launch{
            _getBreweriesPhotos.value = repository.getBreweriesPhotos(breweriesId)
        }
    }
}