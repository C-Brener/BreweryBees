package com.ciandt.breweryees.data

import com.ciandt.breweryees.Model.BreweriesResult
import com.google.gson.Gson
import java.net.URL

class BreweriesRequest {
    companion object{
        private const val URL = "https://bootcamp-mobile-01.eastus.cloudapp.azure.com"
    }
    fun run(): BreweriesResult? {
        val repoListJsonSTR = URL(URL).readText()

        return Gson().fromJson(repoListJsonSTR, BreweriesResult::class.java)
    }
}