package com.myprojects.interview

import com.myprojects.interview.model.TextMineResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TextMineService {
    @GET("dictionary.py/")
    suspend fun getLongForms(@Query("sf") shortForm: String): List<TextMineResponse>
}