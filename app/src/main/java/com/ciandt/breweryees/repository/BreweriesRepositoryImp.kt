package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel
import com.ciandt.breweryees.api.BreweriesService
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess


class BreweriesRepositoryImp(private val service: BreweriesService): BreweriesRespository {
    override suspend fun getBreweriesTopTen(): List<BreweriesModel> {

        val response = service.breweriesTopTen()
        var data: List<BreweriesModel> = listOf(BreweriesModel())

        response.onSuccess{
            data = this.data
        }.onError {
            data = listOf(BreweriesModel())
        }.onException {
            data = listOf(BreweriesModel())
        }

        return data!!
    }
}


