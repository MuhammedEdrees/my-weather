package com.edrees.myweather.app

import android.app.Application
import com.edrees.myweather.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyWeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyWeatherApplication)
            modules(appModule)
        }
    }
}