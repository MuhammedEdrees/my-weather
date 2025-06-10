package com.edrees.myweather.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class Weather(
    val temperature: Temperature = Temperature(),
    val wind: Wind = Wind(),
    val humidityPercentage: Int = 0,
    val precipitation: Precipitation = Precipitation(),
    val pressure: AtmosphericPressure = AtmosphericPressure(),
    val uvIndex: Double = 0.0,
    val condition: Condition = Condition.CLEAR_SKY,
    val isDay: Boolean = true
) {
    data class Temperature(
        val current: Double = 0.0,
        val high: Double = 0.0,
        val low: Double = 0.0,
        val feelsLike: Double = 0.0,
        val unit: Unit = Unit.CELSIUS
    ) {
        enum class Unit(val symbol: String) {
            CELSIUS("°C"),
        }
    }

    data class Wind(
        val speed: Double = 0.0,
        val unit: Unit = Unit.KMH
    ) {
        enum class Unit (val symbol: String){
            KMH("KM/h")
        }
    }

    data class Precipitation(
        val rainProbability: Int = 0,
        val amount: Double = 0.0,
        val unit: Unit = Unit.MM
    ) {
        enum class Unit {
            MM,
        }
    }

    data class AtmosphericPressure(
        val value: Double = 0.0,
        val unit: Unit = Unit.HPA
    ) {
        enum class Unit(val symbol: String) {
            HPA("hPa"),
        }
    }

    enum class Condition {
        CLEAR_SKY,
        MAINLY_CLEAR,
        PARTLY_CLOUDY,
        OVERCAST,
        FOG,
        DEPOSITING_RIME_FOG,
        LIGHT_DRIZZLE,
        MODERATE_DRIZZLE,
        DENSE_DRIZZLE,
        LIGHT_FREEZING_DRIZZLE,
        DENSE_FREEZING_DRIZZLE,
        SLIGHT_RAIN,
        MODERATE_RAIN,
        HEAVY_RAIN,
        LIGHT_FREEZING_RAIN,
        HEAVY_FREEZING_RAIN,
        SLIGHT_SNOW_FALL,
        MODERATE_SNOW_FALL,
        HEAVY_SNOW_FALL,
        SNOW_GRAINS,
        SLIGHT_RAIN_SHOWERS,
        MODERATE_RAIN_SHOWERS,
        VIOLENT_RAIN_SHOWERS,
        SLIGHT_SNOW_SHOWERS,
        HEAVY_SNOW_SHOWERS,
        SLIGHT_THUNDERSTORM,
        MODERATE_THUNDERSTORM,
        SLIGHT_HAIL_THUNDERSTORM,
        HEAVY_HAIL_THUNDERSTORM,
    }

}