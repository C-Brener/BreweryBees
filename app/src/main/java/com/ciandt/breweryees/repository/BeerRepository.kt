package com.ciandt.breweryees.repository

import com.ciandt.breweryees.Model.CervejariaModel
import com.ciandt.breweryees.Model.cervejaria

class BeerRepository {

    fun getBeer():List<CervejariaModel>{
//        return listOf(
//            CervejariaModel()
//        )

        return fakeCervejaria()
    }

    fun fakeCervejaria():MutableList<CervejariaModel> = mutableListOf(
        cervejaria {
            name = "Bar do Detomi"
            rating = 4.9.toFloat()
            type = "Bar"
            distance = "2.5"
        },
        cervejaria {
            name = "Bar do Ari"
            rating = 5.0.toFloat()
            type = "Bar"
            distance = "3.5"
        },
        cervejaria {
            name = "Bar do Paulo"
            rating = 4.8.toFloat()
            type = "Bar"
            distance = "8.5"
        },
        cervejaria {
            name = "Bar do Cachaça"
            rating = 3.2.toFloat()
            type = "Boteco"
            distance = "7.5"
        },
        cervejaria {
            name = "Bar do Joazinho"
            rating = 2.8.toFloat()
            type = "Bar"
            distance = "0.5"
        },
        cervejaria {
            name = "Bar do Ribeirão"
            rating = 2.8.toFloat()
            type = "Bar"
            distance = "0.5"
        },
        cervejaria {
            name = "Bar do Felipe"
            rating = 2.8.toFloat()
            type = "Bar"
            distance = "0.5"
        },
        cervejaria {
            name = "Bar do Thiago"
            rating = 2.8.toFloat()
            type = "Bar"
            distance = "0.5"
        },
        cervejaria {
            name = "Bar do Filo"
            rating = 3.8.toFloat()
            type = "Bar"
            distance = "0.5"
        },
        cervejaria {
            name = "Bar do CIandT"
            rating = 5.0.toFloat()
            type = "Bar"
            distance = "0.5"
        }
    )
}