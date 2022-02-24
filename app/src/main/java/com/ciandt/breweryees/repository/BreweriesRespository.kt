package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.api.BreweriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface BreweriesRespository {

    suspend fun getBreweriesTopTen() : List<BreweriesModel>
    suspend fun getBreweriesCity(search:String) : List<BreweriesModel>

}