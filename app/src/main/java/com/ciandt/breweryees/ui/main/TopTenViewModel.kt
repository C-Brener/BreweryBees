package com.ciandt.breweryees.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class TopTenViewModel(private val repository: BreweriesRespository): ViewModel() {

    private val _showBreweries = MutableLiveData<List<BreweriesModel>>()
    val showBreweries: LiveData<List<BreweriesModel>>
        get() = _showBreweries

    fun loadTopTen() = viewModelScope.launch {
        val result = repository.getBreweriesTopTen()
        _showBreweries.postValue(result)
    }
}