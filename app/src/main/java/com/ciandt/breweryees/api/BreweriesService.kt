package com.ciandt.breweryees.api

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.Model.BreweriesRatingModel
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.*

interface BreweriesService {

    @GET("/breweries/topTen")
    suspend fun breweriesTopTen(): ApiResponse<List<BreweriesModel>>

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("/breweries")
    suspend fun setBreweriesRating(@Body breweriesRatingModel: BreweriesRatingModel): ApiResponse<BreweriesRatingModel>


    @GET("/breweries")
    suspend fun getBreweriesCity(
        @Query(
            value = "by_city",
            encoded = true
        ) by_city: String
    ): ApiResponse<List<BreweriesModel>>

    @GET("/breweries/{breweryId}")
    suspend fun getBreweriesDetails(@Path( value = "breweryId", encoded = true) breweryId: String): ApiResponse<BreweriesModel>

    @GET("/breweries/photos/{breweryId}")
    suspend fun getBreweriesPhotos(@Path( value = "breweryId", encoded = true) breweryId: String): ApiResponse<BreweriesPhotoModel>


}