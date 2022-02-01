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

