package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesService {

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen():ApiResponse<List<BreweriesModel>>

    @GET("/breweries")
    suspend fun getBreweriesCity(@Query(value = "by_city", encoded = true) by_city :String): ApiResponse<List<BreweriesModel>>
}