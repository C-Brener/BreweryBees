package com.ciandt.breweryees.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciandt.breweryees.repository.BreweriesRespository


class DetailsViewModel(var repository : BreweriesRespository): ViewModel {

    var _setRatingLiveData = MutableLiveData<breweriesRatingModel>()
}