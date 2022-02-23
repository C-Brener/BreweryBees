package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesService {

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen():List<BreweriesModel>

}