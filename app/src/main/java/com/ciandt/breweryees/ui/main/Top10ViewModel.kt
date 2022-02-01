package com.ciandt.breweryees.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciandt.breweryees.Model.CervejariaModel
import com.ciandt.breweryees.Model.cervejaria
import com.ciandt.breweryees.repository.BeerRepository

class Top10ViewModel(): ViewModel(
) {
    private val beerRepository = BeerRepository()
    private val _bearListLiveData = MutableLiveData<List<CervejariaModel>>()
    val bearListLiveData :LiveData<List<CervejariaModel>>
    get() = _bearListLiveData

    fun getBeerList(){
       val response =  beerRepository.getBeer()
        //if sucesso
        _bearListLiveData.postValue(response)//response.data
    }
}