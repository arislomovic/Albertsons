package com.myprojects.interview.repository

import com.myprojects.interview.model.TextMineResponse

interface TextMineRepository {
    suspend fun getLongForm(shortForm: String): TextMineResponse?
}