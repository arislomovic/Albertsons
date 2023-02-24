package com.myprojects.interview.stubs.services

import com.myprojects.interview.TextMineService
import com.myprojects.interview.model.LongForm
import com.myprojects.interview.model.TextMineResponse
import com.myprojects.interview.stubs.`object`.TextMineResponseStubs

object ServiceStubs {
    val errorService = object : TextMineService {
        override suspend fun getLongForms(shortForm: String) = throw IllegalArgumentException("")
    }
    val emptyResponseService = object : TextMineService {
        override suspend fun getLongForms(shortForm: String): List<TextMineResponse> = listOf()
    }

    val validResponseService = object : TextMineService {
        override suspend fun getLongForms(shortForm: String): List<TextMineResponse> = listOf(
            TextMineResponseStubs.textMineResponse
        )
    }
}