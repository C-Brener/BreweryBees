package com.ciandt.breweryees.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.repository.BreweriesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopTenViewModel(private val repository: BreweriesRepository): ViewModel() {
    private val breweriesRepository = BreweriesRepository()
    private val _topTenListLiveData = MutableLiveData<List<BreweriesModel>>()
    val topTenListLiveData = _topTenListLiveData

    fun getTopTenList(){

        CoroutineScope(Dispatchers.Main).launch {
            val topTen = withContext(Dispatchers.Default) {
                breweriesRepository.getBreweriesTopTen()
            }
            topTenListLiveData.value = topTen
        }
    }

    class TopTenFragmentFactory(
        private val repository: BreweriesRepository
    ):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TopTenViewModel(repository) as T
        }
    }
}