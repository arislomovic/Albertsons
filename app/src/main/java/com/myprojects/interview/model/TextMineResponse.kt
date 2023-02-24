package com.myprojects.interview.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextMineResponse(
    @Json(name = "sf") val shortForm: String = "",
    @Json(name = "lfs") val longForms: List<LongForm> = listOf()
)

