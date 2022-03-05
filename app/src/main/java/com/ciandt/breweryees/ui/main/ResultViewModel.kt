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

    private val _searchListErrorLiveData = MutableLiveData<Unit>()
    val searchListErrorLiveData :LiveData<Unit>get() = _searchListErrorLiveData

    fun getSearchList(search: String) {
        viewModelScope.launch {
            val result =  breweriesRepository.getBreweriesCity(search)
            if(result.isEmpty()){
                _searchListErrorLiveData.value = Unit

            }else{
                _searchListLiveData.value = result

            }
//            Log.d("MainViewModel", searchListLiveData.toString())
        }
    }

}