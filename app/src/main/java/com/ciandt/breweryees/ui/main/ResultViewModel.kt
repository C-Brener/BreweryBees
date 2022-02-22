package com.ciandt.breweryees.ui.main

import androidx.lifecycle.*
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class ResultViewModel (private val breweriesRepository: BreweriesRespository ): ViewModel() {

    private val _searchListLiveData = MutableLiveData<List<BreweriesModel>>()
    val searchListLiveData = _searchListLiveData


    fun getSearchList(search:String){
        viewModelScope.launch {
            _searchListLiveData.value = breweriesRepository.breweriesInitial()
        }
    }

    class ResultFragmentFactory : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return  ResultViewModel(BreweriesRespository()) as T
        }
    }
}