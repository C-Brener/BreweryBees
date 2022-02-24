package com.ciandt.breweryees.di


import com.ciandt.breweryees.ui.details.DetailsViewModel
import com.ciandt.breweryees.ui.main.ResultViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { DetailsViewModel(get()) }
    factory { TopTenViewModel(get()) }
    factory { ResultViewModel(get())}
}