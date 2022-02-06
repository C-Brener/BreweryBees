package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesService {

    @GET("/breweries")
    suspend fun breweries(@Query(value = "by_city",encoded = true) by_city : String) : List<BreweriesModel>

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen():List<BreweriesModel>

    @GET("/breweries/photos")
    suspend fun breweriesPhotos():List<BreweriesModel>

}