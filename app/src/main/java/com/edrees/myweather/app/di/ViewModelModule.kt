package com.edrees.myweather.app.di

import com.edrees.myweather.ui.weather.WeatherViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::WeatherViewModel)
}