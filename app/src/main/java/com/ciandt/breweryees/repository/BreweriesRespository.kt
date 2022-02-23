package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.BreweriesModel

interface BreweriesRespository {
    suspend fun getBreweriesTopTen() : List<BreweriesModel>
}