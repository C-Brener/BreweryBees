package com.ciandt.breweryees.ui.main

import android.R
import android.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesResult
import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.android.synthetic.main.fragment_top10.*
import kotlinx.coroutines.*

class Top10ViewModel(): ViewModel(
) {
    private val beerRepository = BreweriesRepository()
    private val _bearListLiveData = MutableLiveData<BreweriesModel>()
    val bearListLiveData :LiveData<BreweriesModel>
    get() = _bearListLiveData

    fun getBeerList(){
       //val response =  beerRepository.getBeer()
        //if sucesso
        //_bearListLiveData.postValue(response)//response.data
    }


}