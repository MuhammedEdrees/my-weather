package com.edrees.myweather.ui.weather

import com.edrees.myweather.domain.model.Location
import com.edrees.myweather.domain.model.WeatherForecast

data class WeatherUiState(
    val isLoading: Boolean = true,
    val currentLocation: Location = Location(),
    val weatherForecast: WeatherForecast = WeatherForecast()
)
