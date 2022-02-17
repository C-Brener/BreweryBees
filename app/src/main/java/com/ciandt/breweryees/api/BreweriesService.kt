package com.ciandt.breweryees.api

import retrofit2.http.GET
import retrofit2.http.Query

interface BreweriesService {

    @GET("/breweries")
    suspend fun breweriesCity(@Query(value = "by_city",encoded = true) by_city : String)
}