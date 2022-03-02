package com.ciandt.breweryees.di


import com.ciandt.breweryees.ui.main.TopTenViewModel
import com.ciandt.breweryees.ui.details.DetailsViewModel
import com.ciandt.breweryees.ui.details.GalleryViewModel
import com.ciandt.breweryees.ui.main.ResultViewModel
import com.ciandt.breweryees.ui.ratedBreweries.ResultRatedViewModel
import org.koin.dsl.module

val viewModelModule = module {

    //implemente seu model aqui
    //.main
    //factory { MainViewModel(get()) }
    factory { TopTenViewModel(get()) }
    factory { DetailsViewModel(get()) }
    factory { ResultViewModel(get())}
    factory { GalleryViewModel(get()) }
    factory { ResultRatedViewModel(get()) }
    //.details

}