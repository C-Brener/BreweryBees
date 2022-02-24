package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.Model.BreweriesRatingModel

interface BreweriesRespository {

    suspend fun getBreweriesTopTen() : List<BreweriesModel>

    suspend fun getBreweriesCity(search:String) : List<BreweriesModel>

    suspend fun setBreweriesRating(breweriesRating: BreweriesRatingModel): BreweriesRatingModel

    suspend fun getBreweriesDetails(breweriesId:String): BreweriesModel

    suspend fun getBreweriesPhotos(breweriesId:String): List<BreweriesPhotoModel>
}