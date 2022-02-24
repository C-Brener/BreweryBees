package com.ciandt.breweryees.repository

import android.annotation.SuppressLint
import android.util.Log
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.api.BreweriesService

class BreweriesRespositoryIpml(private val service: BreweriesService ): BreweriesRespository {

    @SuppressLint("LongLogTag")
    override suspend fun getBreweriesTopTen() : List<BreweriesModel>{
        try {
            return service.breweriesTopTen()
        } catch (e: Exception) {
            Log.e("BreweriesRespositoryIpml", e.message, e)
            return emptyList()
        }

    }
}