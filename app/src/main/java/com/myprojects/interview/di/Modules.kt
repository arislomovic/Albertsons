package com.myprojects.interview.di

import com.squareup.moshi.Moshi
import com.myprojects.interview.TextMineService
import com.myprojects.interview.repository.TextMineRepository
import com.myprojects.interview.repository.TextMineRepositoryImpl
import com.myprojects.interview.viewmodel.TextMineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val textMineModule = module {

    factory {
        Moshi.Builder().build()
    }

    factory<TextMineService> {
        Retrofit
            .Builder()
            .baseUrl("http://www.nactem.ac.uk/software/acromine/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
            .create(TextMineService::class.java)
    }

    factory<TextMineRepository> {
        TextMineRepositoryImpl(get())
    }

    viewModel {
        TextMineViewModel(get())
    }
}