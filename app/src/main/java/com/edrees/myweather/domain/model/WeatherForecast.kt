package com.edrees.myweather.domain.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class WeatherForecast(
    val currentWeather: Weather = Weather(),
    val hourlyForecasts: List<HourlyForecast> = emptyList(),
    val dailyForecasts: List<DailyForecast> = emptyList(),
) {
    data class HourlyForecast(
        val dateTime: LocalDateTime,
        val temperature: Double,
        val condition: Weather.Condition,
        val isDay: Boolean = true,
    )

    data class DailyForecast(
        val date: LocalDate,
        val highTemperature: Double,
        val lowTemperature: Double,
        val condition: Weather.Condition,
    )
}
