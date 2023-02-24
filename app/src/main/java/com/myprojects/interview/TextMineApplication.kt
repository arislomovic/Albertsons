package com.myprojects.interview

import android.app.Application
import com.myprojects.interview.di.textMineModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TextMineApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TextMineApplication)
            modules(
                textMineModule
            )
        }
    }

}