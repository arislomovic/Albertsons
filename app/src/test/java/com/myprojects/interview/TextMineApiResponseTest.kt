package com.myprojects.interview

import com.myprojects.interview.helper.JsonResponseLoader
import com.myprojects.interview.model.TextMineResponse
import com.myprojects.interview.stubs.`object`.TextMineResponseStubs
import org.junit.Test

class TextMineApiResponseTest {
    @Test
    fun testTextMineApiResponseResponseBody() {
        val body = JsonResponseLoader.loadJsonArrayToPojo<TextMineResponse>("textMineResponse.json")
        assert(body?.get(0) == TextMineResponseStubs.textMineResponse)
    }
}