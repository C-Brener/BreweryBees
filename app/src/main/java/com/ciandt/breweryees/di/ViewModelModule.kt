package com.ciandt.breweryees.di

import com.ciandt.breweryees.ui.MainViewModel
import com.ciandt.breweryees.ui.main.TopTenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel(get()) }
    factory { TopTenViewModel(get()) }
}