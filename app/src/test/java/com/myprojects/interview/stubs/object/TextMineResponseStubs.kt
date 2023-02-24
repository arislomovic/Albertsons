package com.myprojects.interview.stubs.`object`

import com.myprojects.interview.model.LongForm
import com.myprojects.interview.model.TextMineResponse

object TextMineResponseStubs {
    val longFormList = listOf(
        LongForm("heavy meromyosin", frequency = 267, 1971),
        LongForm("hidden Markov model", frequency = 245, 1990),
        LongForm("hexamethylmelamine", frequency = 55, 1976),
    )
    val textMineResponse = TextMineResponse(
        shortForm = "HMM",
        longForms = longFormList
    )
}