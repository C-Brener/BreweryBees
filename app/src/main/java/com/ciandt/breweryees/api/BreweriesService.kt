package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BreweriesService {

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen():ApiResponse<List<BreweriesModel>>

    @GET("/breweries")
    suspend fun breweriesInitial(@Query(value = "by_city", encoded = true) by_city :String):List<BreweriesModel>

    @GET("/breweries/{breweryId}")
    suspend fun breweriesId(@Path( value = "id", encoded = true)breweryId :String):List<BreweriesModel>

}