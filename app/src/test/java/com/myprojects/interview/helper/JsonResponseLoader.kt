package com.myprojects.interview.helper

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.File
import java.lang.reflect.Type


object JsonResponseLoader {
    private const val JSON_FILE_PATH =
        "../app/src/test/java/com/myprojects/interview/stubs/json/"

    fun loadJson(name: String) = File(JSON_FILE_PATH + name).readText(Charsets.UTF_8)

    inline fun <reified T> loadJsonToPojo(name: String) = Moshi
            .Builder()
            .build()
            .adapter(T::class.java)
            .fromJson(loadJson(name))

    inline fun <reified T> loadJsonArrayToPojo(name: String) = Moshi
        .Builder()
        .build()
        .adapter<List<T>>(Types.newParameterizedType(MutableList::class.java, T::class.java))
        .fromJson(loadJson(name))

}