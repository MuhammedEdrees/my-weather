package com.edrees.myweather.domain.repository

import com.edrees.myweather.domain.model.Location
import com.edrees.myweather.domain.model.WeatherForecast

interface WeatherRepository {
    suspend fun getWeatherForecastByLocation(
        location: Location
    ): WeatherForecast
}