package com.ciandt.breweryees.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.Model.BreweriesRatingModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch


class DetailsViewModel(var repository: BreweriesRespository) : ViewModel() {

    private var _setRatingLiveData = MutableLiveData<BreweriesRatingModel>()
    val setBreweriesRating: LiveData<BreweriesRatingModel> = _setRatingLiveData

    fun setRating(email: String, breweriesId: String, rating: Double) {

        val breweriesRating = BreweriesRatingModel(email, breweriesId, rating)
        viewModelScope.launch {
            _setRatingLiveData.value = repository.setBreweriesRating(breweriesRating)
        }
    }
}