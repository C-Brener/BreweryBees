package com.ciandt.breweryees.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRepositoryImp
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class ResultViewModel(private val breweriesRepository: BreweriesRespository) : ViewModel() {

    private val _searchListLiveData = MutableLiveData<List<BreweriesModel>>()
    val searchListLiveData: LiveData<List<BreweriesModel>> get() = _searchListLiveData


    fun getSearchList(search: String) {
        viewModelScope.launch {
            _searchListLiveData.value = breweriesRepository.getBreweriesCity(search)
//            Log.d("MainViewModel", searchListLiveData.toString())
        }
    }

}