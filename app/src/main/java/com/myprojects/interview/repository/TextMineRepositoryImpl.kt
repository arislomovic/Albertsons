package com.myprojects.interview.repository

import android.util.Log
import com.myprojects.interview.TextMineService
import com.myprojects.interview.model.TextMineResponse

private const val TAG = "TextMineRepository"

class TextMineRepositoryImpl(private val service: TextMineService) : TextMineRepository {

    override suspend fun getLongForm(shortForm: String): TextMineResponse? {
        return service
            .runCatching { getLongForms(shortForm) }
            .onFailure {
                Log.e(TAG, "mineText", it)
            }
            .onSuccess {
                Log.d(TAG, "mineText success")
            }
            .getOrNull()
            ?.firstOrNull()
    }
}