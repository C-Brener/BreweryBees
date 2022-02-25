package com.ciandt.breweryees.di


import com.ciandt.breweryees.ui.main.TopTenViewModel
import org.koin.dsl.module

val viewModelModule = module {

    //implemente seu model aqui
    //.main
    //factory { MainViewModel(get()) }
    factory { TopTenViewModel(get()) }


    //.details

}