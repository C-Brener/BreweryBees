package com.ciandt.breweryees.di

import com.ciandt.breweryees.repository.BreweriesRespository
import com.ciandt.breweryees.repository.BreweriesRespositoryIpml
import org.koin.dsl.module

val repositoriesModule = module {
    factory<BreweriesRespository> {
        BreweriesRespositoryIpml(get())
    }
}