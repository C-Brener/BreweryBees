package com.ciandt.breweryees.di

import com.ciandt.breweryees.BuildConfig
import com.ciandt.breweryees.api.BreweriesService
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkingModule = module{

    single{
        OkHttpClient.Builder().build()
    }

    single{
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        val retrofit = get<Retrofit>()
        retrofit.create(BreweriesService::class.java)
    }
}
