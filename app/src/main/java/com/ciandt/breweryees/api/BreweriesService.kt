package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BreweriesService {

    @GET("/breweries")
    suspend fun breweries(@Query(value = "by_city",encoded = true) by_city : String) : List<BreweriesModel>

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen():List<BreweriesModel>

    @GET("/breweries/photos/{breweryId}")
    suspend fun breweriesPhotos(@Path(value = "breweryId", encoded = true) by_city : String):List<BreweriesPhotoModel>

}