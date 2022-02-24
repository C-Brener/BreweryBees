package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.Model.BreweriesPhotoModel
import com.ciandt.breweryees.Model.BreweriesRatingModel
import com.ciandt.breweryees.api.BreweriesService
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess


class BreweriesRepositoryImp(private val service: BreweriesService): BreweriesRespository {
    override suspend fun getBreweriesTopTen(): List<BreweriesModel> {

        val response = service.breweriesTopTen()
        var data: List<BreweriesModel>? =null

        response.onSuccess{
            data = this.data
        }.onError {
            data = null
        }.onException {
            data = null
        }
        return data!!
    }

    override suspend fun getBreweriesCity(search: String): List<BreweriesModel> {
        val responseSearchCity = service.getBreweriesCity(search)
        var data : List<BreweriesModel>? = null

        responseSearchCity.onSuccess {
            data = this.data
        }.onError {
            data = listOf<BreweriesModel>()
        }.onException {
            data = listOf<BreweriesModel>()
        }
        return data!!
    }

    override suspend fun setBreweriesRating(breweriesRating : BreweriesRatingModel): BreweriesRatingModel {

        val response = service.setBreweriesRating(breweriesRating)
        var data :BreweriesRatingModel? = BreweriesRatingModel()

        response.onSuccess {
            data = this.data
        }.onError {
            data = BreweriesRatingModel()
        }.onException {
            data = BreweriesRatingModel()
        }
        return data!!
    }

    override suspend fun getBreweriesDetails(breweriesId: String): BreweriesModel{
        val responseDetails = service.getBreweriesDetails(breweriesId)
        var data : BreweriesModel? = null

        responseDetails.onSuccess {
            data = this.data
        }.onError {
            data = BreweriesModel()
        }.onException {
            data = BreweriesModel()
        }
        return data!!
    }

    override suspend fun getBreweriesPhotos(breweriesId: String): List<BreweriesPhotoModel> {
        val responsePhotos = service.getBreweriesPhotos(breweriesId)
        var data : List<BreweriesPhotoModel>? = null

        responsePhotos.onSuccess {
            data = listOf(this.data)
        }.onError {
            data = listOf<BreweriesPhotoModel>()
        }.onException {
            data = listOf<BreweriesPhotoModel>()
        }
        return data!!
    }


}
