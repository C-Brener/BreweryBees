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

    private val _searchListErrorEvaluationsLiveData = MutableLiveData<Unit>()
    val searchListErrorEvaluationsLiveData : LiveData<Unit>get() = _searchListErrorEvaluationsLiveData


    fun getSearchListEvaluations(email:String){
        viewModelScope.launch {
            val result =  breweriesRespository.getBreweriesEvaluations(email)
            if (result.isEmpty()){
                _searchListErrorEvaluationsLiveData.value = Unit
            }else{
                _searchListEvaluationsLiveData.value = result
            }
        }
    }

}