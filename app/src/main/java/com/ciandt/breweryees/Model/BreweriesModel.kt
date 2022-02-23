package com.ciandt.breweryees.Model

data class BreweriesModel(
    var id:String? = null,
    var name: String? = null,
    var brewery_type:String? = null,
    var street:String? = null,
    var address2:String? = null,
    var address3:String? = null,
    var city:String? = null,
    var state:String? = null,
    var postal_code:String? = null,
    var country:String? = null,
    var longitude:Double = 0.0,
    var latitude:Double = 0.0,
    var website_url:String? = null,
    var phone:String? = null,
    var average:Double? = null,
    var size_evaluations:Int? = null,
    var photos: List<String>? = null
)

