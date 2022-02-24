package com.ciandt.breweryees.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class TopTenViewModel(private val breweriesRespository: BreweriesRespository) : ViewModel(){

        private val _topTenList = MutableLiveData<List<BreweriesModel>>()
        val topTenList : LiveData<List<BreweriesModel>>
        get() = _topTenList

    fun getTopTenList() {
        viewModelScope.launch {
            _topTenList.value = breweriesRespository.getBreweriesTopTen()
        }
    }

}