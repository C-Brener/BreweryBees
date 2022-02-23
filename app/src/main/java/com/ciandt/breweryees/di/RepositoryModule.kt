package com.ciandt.breweryees.di

import com.ciandt.breweryees.repository.BreweriesRepositoryImp
import com.ciandt.breweryees.repository.BreweriesRespository
import org.koin.dsl.module

val repositoryModule = module {
    factory<BreweriesRespository> {
        BreweriesRepositoryImp(get())
    }
}