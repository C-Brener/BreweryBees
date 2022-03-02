package com.ciandt.breweryees.ui.ratedBreweries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class ResultRatedViewModel(private val breweriesRespository: BreweriesRespository) : ViewModel() {

    private val _searchListEvaluationsLiveData = MutableLiveData<List<BreweriesModel>>()
    val searchListEvaluationsLiveData : LiveData<List<BreweriesModel>> get() = _searchListEvaluationsLiveData

    fun getSearchListEvaluations(email:String){
        viewModelScope.launch {
            _searchListEvaluationsLiveData.value = breweriesRespository.getBreweriesEvaluations(email)
        }
    }

}