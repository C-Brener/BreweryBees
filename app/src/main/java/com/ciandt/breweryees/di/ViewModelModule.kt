package com.ciandt.breweryees.di


import com.ciandt.breweryees.ui.details.DetailsViewModel
import org.koin.dsl.module

val viewModelModule = module {

    //implemente seu model aqui
    //.main
    //factory { MainViewModel(get()) }

    factory { DetailsViewModel(get()) }


    //.details

}