package com.ciandt.breweryees.Model

import retrofit2.http.Field

data class BreweriesRatingModel(
    var email: String? = null,
    var brewery_id: String? = null,
    var evaluation_grade: Double? = 0.0
)
