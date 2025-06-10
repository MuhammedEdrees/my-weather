package com.edrees.myweather.data.model.mapper

import com.edrees.myweather.data.model.WeatherForecastDto
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.domain.model.WeatherForecast
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun WeatherForecastDto.toWeatherForecast(): WeatherForecast {
    val currentWeather = mapCurrentWeatherToDomain(this)
    val hourlyForecasts = mapHourlyForecastsToDomain(this)
    val dailyForecasts = mapDailyForecastsToDomain(this)

    return WeatherForecast(
        currentWeather = currentWeather,
        hourlyForecasts = hourlyForecasts,
        dailyForecasts = dailyForecasts,
    )
}

private fun mapCurrentWeatherToDomain(dto: WeatherForecastDto): Weather {
    val current = dto.current

    return Weather(
        temperature = Weather.Temperature(
            current = current.temperature_2m,
            high = dto.daily.temperature_2m_max.firstOrNull() ?: current.temperature_2m,
            low = dto.daily.temperature_2m_min.firstOrNull() ?: current.temperature_2m,
            feelsLike = current.apparent_temperature,
            unit = Weather.Temperature.Unit.entries.first { it.symbol == dto.current_units.temperature_2m }
        ),
        wind = Weather.Wind(
            speed = current.wind_speed_10m,
            unit = Weather.Wind.Unit.KMH
        ),
        humidityPercentage = current.relative_humidity_2m,
        precipitation = Weather.Precipitation(
            rainProbability = calculateRainProbability(current.rain),
            amount = current.rain,
            unit = Weather.Precipitation.Unit.MM
        ),
        pressure = Weather.AtmosphericPressure(
            value = current.pressure_msl,
            unit = Weather.AtmosphericPressure.Unit.HPA
        ),
        uvIndex = dto.daily.uv_index_max.firstOrNull() ?: 0.0,
        condition = mapWeatherCodeToCondition(current.weather_code),
        isDay = current.is_day == 1
    )
}

private fun mapHourlyForecastsToDomain(dto: WeatherForecastDto): List<WeatherForecast.HourlyForecast> {
    val hourly = dto.hourly

    return hourly.time.mapIndexed { index, timeString ->
        WeatherForecast.HourlyForecast(
            dateTime = parseIsoDateTime(timeString),
            temperature = hourly.temperature_2m.getOrNull(index) ?: 0.0,
            isDay = hourly.is_day.getOrElse(index) { 1 } == 1,
            condition = mapWeatherCodeToCondition(hourly.weather_code.getOrNull(index) ?: 0),
        )
    }
}

private fun mapDailyForecastsToDomain(dto: WeatherForecastDto): List<WeatherForecast.DailyForecast> {
    val daily = dto.daily

    return daily.time.mapIndexed { index, dateString ->
        val date = LocalDate.parse(dateString)
        WeatherForecast.DailyForecast(
            date = date,
            highTemperature = daily.temperature_2m_max.getOrNull(index) ?: 0.0,
            lowTemperature = daily.temperature_2m_min.getOrNull(index) ?: 0.0,
            condition = mapWeatherCodeToCondition(daily.weather_code.getOrNull(index) ?: 0),
        )
    }
}

private fun mapWeatherCodeToCondition(code: Int): Weather.Condition {
    return when (code) {
        0 -> Weather.Condition.CLEAR_SKY
        1 -> Weather.Condition.MAINLY_CLEAR
        2 -> Weather.Condition.PARTLY_CLOUDY
        3 -> Weather.Condition.OVERCAST
        45 -> Weather.Condition.FOG
        48 -> Weather.Condition.DEPOSITING_RIME_FOG
        51 -> Weather.Condition.LIGHT_DRIZZLE
        53 -> Weather.Condition.MODERATE_DRIZZLE
        55 -> Weather.Condition.DENSE_DRIZZLE
        56 -> Weather.Condition.LIGHT_FREEZING_DRIZZLE
        57 -> Weather.Condition.DENSE_FREEZING_DRIZZLE
        61 -> Weather.Condition.SLIGHT_RAIN
        63 -> Weather.Condition.MODERATE_RAIN
        65 -> Weather.Condition.HEAVY_RAIN
        66 -> Weather.Condition.LIGHT_FREEZING_RAIN
        67 -> Weather.Condition.HEAVY_FREEZING_RAIN
        71 -> Weather.Condition.SLIGHT_SNOW_FALL
        73 -> Weather.Condition.MODERATE_SNOW_FALL
        75 -> Weather.Condition.HEAVY_SNOW_FALL
        77 -> Weather.Condition.SNOW_GRAINS
        80 -> Weather.Condition.SLIGHT_RAIN_SHOWERS
        81 -> Weather.Condition.MODERATE_RAIN_SHOWERS
        82 -> Weather.Condition.VIOLENT_RAIN_SHOWERS
        85 -> Weather.Condition.SLIGHT_SNOW_SHOWERS
        86 -> Weather.Condition.HEAVY_SNOW_SHOWERS
        95 -> Weather.Condition.SLIGHT_THUNDERSTORM
        96 -> Weather.Condition.MODERATE_THUNDERSTORM
        97 -> Weather.Condition.SLIGHT_HAIL_THUNDERSTORM
        99 -> Weather.Condition.HEAVY_HAIL_THUNDERSTORM
        else -> Weather.Condition.CLEAR_SKY
    }
}

private fun parseIsoDateTime(isoString: String): LocalDateTime {
    return try {
        LocalDateTime.parse(isoString)
    } catch (e: Exception) {
        val instant = Instant.parse(isoString)
        instant.toLocalDateTime(TimeZone.currentSystemDefault())
    }
}

private fun calculateRainProbability(rainAmount: Double): Int {
    return when {
        rainAmount <= 0.0 -> 0
        rainAmount <= 0.1 -> 20
        rainAmount <= 0.5 -> 40
        rainAmount <= 1.0 -> 60
        rainAmount <= 2.0 -> 80
        else -> 100
    }
}