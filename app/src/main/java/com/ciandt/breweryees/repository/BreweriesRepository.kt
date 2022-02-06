package com.ciandt.breweryees.repository

import android.R
import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.api.BreweriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreweriesRepository {

    private val service: BreweriesService

    companion object{
        private const val BASE_URL = "https://bootcamp-mobile-01.eastus.cloudapp.azure.com"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(BreweriesService::class.java)
    }

    suspend fun getBreweriesTopTen() : List<BreweriesModel>{
        return service.breweriesTopTen()
    }

    suspend fun getBreweriesPhotos(search :String): List<BreweriesPhotoModel>{
        return service.breweriesPhotos(search)
    }
}