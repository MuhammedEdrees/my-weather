package com.edrees.myweather.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastDto(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current_units: CurrentUnits,
    val current: Current,
    val hourly_units: HourlyUnits,
    val hourly: Hourly,
    val daily_units: DailyUnits,
    val daily: Daily
) {
    @Serializable
    data class CurrentUnits(
        val time: String,
        val interval: String,
        val temperature_2m: String,
        val wind_speed_10m: String,
        val relative_humidity_2m: String,
        val rain: String,
        val weather_code: String,
        val apparent_temperature: String,
        val pressure_msl: String,
        val is_day: String,
        val precipitation: String
    )
    @Serializable
    data class Current(
        val time: String,
        val interval: Int,
        val temperature_2m: Double,
        val wind_speed_10m: Double,
        val relative_humidity_2m: Int,
        val rain: Double,
        val weather_code: Int,
        val apparent_temperature: Double,
        val pressure_msl: Double,
        val is_day: Int,
        val precipitation: Double
    )

    @Serializable
    data class HourlyUnits(
        val time: String,
        val temperature_2m: String,
        val weather_code: String,
        val is_day: String
    )

    @Serializable
    data class Hourly(
        val time: List<String>,
        val temperature_2m: List<Double>,
        val weather_code: List<Int>,
        val is_day: List<Int>
    )

    @Serializable
    data class DailyUnits(
        val time: String,
        val temperature_2m_max: String,
        val temperature_2m_min: String,
        val weather_code: String,
        val uv_index_max: String
    )

    @Serializable
    data class Daily(
        val time: List<String>,
        val temperature_2m_max: List<Double>,
        val temperature_2m_min: List<Double>,
        val weather_code: List<Int>,
        val uv_index_max: List<Double>
    )
}