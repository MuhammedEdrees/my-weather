package com.edrees.myweather.data.repository

import com.edrees.myweather.data.model.WeatherForecastDto
import com.edrees.myweather.data.model.mapper.toWeatherForecast
import com.edrees.myweather.domain.model.Location
import com.edrees.myweather.domain.model.WeatherForecast
import com.edrees.myweather.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.HttpStatusCode
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

class WeatherRepositoryImpl(
    private val httpClient: HttpClient
) : WeatherRepository {
    override suspend fun getWeatherForecastByLocation(location: Location): WeatherForecast {
        val now = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        val currentDateTime = now.toLocalDateTime(timeZone)
        val nextHour = Clock.System.now().plus(1, DateTimeUnit.HOUR)
        val nextHourDateTime = nextHour.toLocalDateTime(timeZone)

        val startHour =
            "${nextHourDateTime.date}T${nextHourDateTime.hour.toString().padStart(2, '0')}:00"
        val endDateTime = nextHour.plus(23, DateTimeUnit.HOUR).toLocalDateTime(timeZone)
        val endHour = "${endDateTime.date}T${endDateTime.hour.toString().padStart(2, '0')}:00"

        val startDate =
            now.plus(1, DateTimeUnit.DAY, timeZone).toLocalDateTime(timeZone).date.toString()
        val endDate = currentDateTime.date.plus(7, DateTimeUnit.DAY).toString()

        val response = httpClient.get {
            url("https://api.open-meteo.com/v1/forecast")
            parameter("latitude", location.latitude)
            parameter("longitude", location.longitude)
            parameter("daily", "temperature_2m_max,temperature_2m_min,weather_code,uv_index_max")
            parameter("hourly", "temperature_2m,weather_code,is_day")
            parameter(
                "current",
                "temperature_2m,wind_speed_10m,relative_humidity_2m,rain,weather_code,apparent_temperature,pressure_msl,is_day,precipitation"
            )
            parameter("start_hour", startHour)
            parameter("end_hour", endHour)
            parameter("start_date", startDate)
            parameter("end_date", endDate)
            parameter("timezone", "Africa/Cairo")
        }

        return response
            .takeIf { it.status == HttpStatusCode.OK }
            ?.body<WeatherForecastDto>()
            ?.toWeatherForecast()
            ?: throw IllegalStateException("Failed to fetch weather data: ${response.status}")
    }
}