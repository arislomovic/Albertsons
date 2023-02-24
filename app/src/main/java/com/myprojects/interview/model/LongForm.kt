package com.myprojects.interview.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LongForm(
    @Json(name = "lf") val longForm: String = "",
    @Json(name = "freq") val frequency: Int = 0,
    @Json(name = "since") val originYear: Int = 0,
    @Json(name = "vars") val variations: List<LongForm>? = null,
)