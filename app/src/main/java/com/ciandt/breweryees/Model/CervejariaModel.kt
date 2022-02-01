package com.ciandt.breweryees.Model

import android.provider.ContactsContract

data class CervejariaModel (
    var name :String? = null,
    var rating :Float? = null,
    var type :String? = null,
    var distance:String? = null
)
class CervejariaBuilder{
    var name :String? = null
    var rating :Float? = null
    var type :String? = null
    var distance:String? = null

    fun build() : CervejariaModel = CervejariaModel(name,rating,type,distance)
}

fun cervejaria(block: CervejariaBuilder.()->Unit): CervejariaModel = CervejariaBuilder().apply(block).build()

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
