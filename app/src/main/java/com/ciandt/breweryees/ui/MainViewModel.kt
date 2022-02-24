package com.ciandt.breweryees.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.breweryees.repository.BreweriesRespository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: BreweriesRespository): ViewModel() {

    fun loadTopTen() {
        viewModelScope.launch {
            val result = repository.getBreweriesTopTen()
            Log.d("MainViewModel", result.toString())
        }
    }
}