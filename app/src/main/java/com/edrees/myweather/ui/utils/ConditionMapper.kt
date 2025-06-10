package com.edrees.myweather.ui.utils

import androidx.compose.runtime.Composable
import com.edrees.myweather.R
import com.edrees.myweather.domain.model.Weather


val Weather.Condition.titleRes: Int
    get() = when (this) {
        Weather.Condition.CLEAR_SKY -> R.string.clear_sky
        Weather.Condition.MAINLY_CLEAR -> R.string.mainly_clear
        Weather.Condition.PARTLY_CLOUDY -> R.string.partly_cloudy
        Weather.Condition.OVERCAST -> R.string.overcast
        Weather.Condition.FOG -> R.string.fog
        Weather.Condition.DEPOSITING_RIME_FOG -> R.string.depositing_rime_fog
        Weather.Condition.LIGHT_DRIZZLE -> R.string.light_drizzle
        Weather.Condition.MODERATE_DRIZZLE -> R.string.moderate_drizzle
        Weather.Condition.DENSE_DRIZZLE -> R.string.dense_drizzle
        Weather.Condition.LIGHT_FREEZING_DRIZZLE -> R.string.light_freezing_drizzle
        Weather.Condition.DENSE_FREEZING_DRIZZLE -> R.string.dense_freezing_drizzle
        Weather.Condition.SLIGHT_RAIN -> R.string.slight_rain
        Weather.Condition.MODERATE_RAIN -> R.string.moderate_rain
        Weather.Condition.HEAVY_RAIN -> R.string.heavy_rain
        Weather.Condition.LIGHT_FREEZING_RAIN -> R.string.light_freezing_rain
        Weather.Condition.HEAVY_FREEZING_RAIN -> R.string.heavy_freezing_rain
        Weather.Condition.SLIGHT_SNOW_FALL -> R.string.slight_snow_fall
        Weather.Condition.MODERATE_SNOW_FALL -> R.string.moderate_snow_fall
        Weather.Condition.HEAVY_SNOW_FALL -> R.string.heavy_snow_fall
        Weather.Condition.SNOW_GRAINS -> R.string.snow_grains
        Weather.Condition.SLIGHT_RAIN_SHOWERS -> R.string.slight_rain_showers
        Weather.Condition.MODERATE_RAIN_SHOWERS -> R.string.moderate_rain_showers
        Weather.Condition.VIOLENT_RAIN_SHOWERS -> R.string.violent_rain_showers
        Weather.Condition.SLIGHT_SNOW_SHOWERS -> R.string.slight_snow_showers
        Weather.Condition.HEAVY_SNOW_SHOWERS -> R.string.heavy_snow_showers
        Weather.Condition.SLIGHT_THUNDERSTORM -> R.string.slight_thunderstorm
        Weather.Condition.MODERATE_THUNDERSTORM -> R.string.moderate_thunderstorm
        Weather.Condition.SLIGHT_HAIL_THUNDERSTORM -> R.string.slight_hail_thunderstorm
        Weather.Condition.HEAVY_HAIL_THUNDERSTORM -> R.string.heavy_hail_thunderstorm
    }

fun Weather.Condition.toDrawableRes(isNight: Boolean): Int = when {
    this == Weather.Condition.CLEAR_SKY && isNight -> R.drawable.clear_sky_night
    this == Weather.Condition.CLEAR_SKY -> R.drawable.clear_sky_day
    this == Weather.Condition.MAINLY_CLEAR && isNight -> R.drawable.mainly_clear_night
    this == Weather.Condition.MAINLY_CLEAR -> R.drawable.mainly_clear_day
    this == Weather.Condition.PARTLY_CLOUDY && isNight-> R.drawable.partly_cloudy_night
    this == Weather.Condition.PARTLY_CLOUDY -> R.drawable.partly_cloudy_day
    this == Weather.Condition.OVERCAST && isNight -> R.drawable.overcast_night
    this == Weather.Condition.OVERCAST -> R.drawable.overcast_day
    this == Weather.Condition.FOG && isNight -> R.drawable.fog_night
    this == Weather.Condition.FOG -> R.drawable.fog_day
    this == Weather.Condition.DEPOSITING_RIME_FOG && isNight -> R.drawable.depositing_rime_fog_night
    this == Weather.Condition.DEPOSITING_RIME_FOG -> R.drawable.depositing_rime_fog_day
    this == Weather.Condition.LIGHT_DRIZZLE && isNight-> R.drawable.light_drizzle_night
    this == Weather.Condition.LIGHT_DRIZZLE -> R.drawable.light_drizzle_day
    this == Weather.Condition.MODERATE_DRIZZLE && isNight-> R.drawable.moderate_drizzle_night
    this == Weather.Condition.MODERATE_DRIZZLE -> R.drawable.moderate_drizzle_day
    this == Weather.Condition.DENSE_DRIZZLE && isNight-> R.drawable.dense_drizzle_night
    this == Weather.Condition.DENSE_DRIZZLE -> R.drawable.dense_drizzle_day
    this == Weather.Condition.LIGHT_FREEZING_DRIZZLE && isNight-> R.drawable.light_freezing_drizzle_night
    this == Weather.Condition.LIGHT_FREEZING_DRIZZLE -> R.drawable.light_freezing_drizzle_day
    this == Weather.Condition.DENSE_FREEZING_DRIZZLE && isNight-> R.drawable.dense_freezing_drizzle_night
    this == Weather.Condition.DENSE_FREEZING_DRIZZLE -> R.drawable.dense_freezing_drizzle_day
    this == Weather.Condition.SLIGHT_RAIN && isNight-> R.drawable.slight_rain_night
    this == Weather.Condition.SLIGHT_RAIN -> R.drawable.slight_rain_day
    this == Weather.Condition.MODERATE_RAIN && isNight -> R.drawable.moderate_rain_night
    this == Weather.Condition.MODERATE_RAIN -> R.drawable.moderate_rain_day
    this == Weather.Condition.HEAVY_RAIN && isNight-> R.drawable.heavy_rain_night
    this == Weather.Condition.HEAVY_RAIN -> R.drawable.heavy_rain_day
    this == Weather.Condition.LIGHT_FREEZING_RAIN && isNight-> R.drawable.light_freezing_night
    this == Weather.Condition.LIGHT_FREEZING_RAIN -> R.drawable.light_freezing_rain_day
    this == Weather.Condition.HEAVY_FREEZING_RAIN && isNight-> R.drawable.heavy_freezing_rain_night
    this == Weather.Condition.HEAVY_FREEZING_RAIN -> R.drawable.heavy_freezing_rain_day
    this == Weather.Condition.SLIGHT_SNOW_FALL && isNight-> R.drawable.slight_snow_fall_night
    this == Weather.Condition.SLIGHT_SNOW_FALL -> R.drawable.slight_snow_fall_day
    this == Weather.Condition.MODERATE_SNOW_FALL && isNight-> R.drawable.moderate_snow_fall_night
    this == Weather.Condition.MODERATE_SNOW_FALL -> R.drawable.moderate_snow_fall_day
    this == Weather.Condition.HEAVY_SNOW_FALL && isNight-> R.drawable.heavy_snow_fall_night
    this == Weather.Condition.HEAVY_SNOW_FALL -> R.drawable.heavy_snow_fall_day
    this == Weather.Condition.SNOW_GRAINS && isNight -> R.drawable.snow_grains_night
    this == Weather.Condition.SNOW_GRAINS -> R.drawable.snow_grains_day
    this == Weather.Condition.SLIGHT_RAIN_SHOWERS && isNight -> R.drawable.slight_rain_showers_night
    this == Weather.Condition.SLIGHT_RAIN_SHOWERS -> R.drawable.slight_rain_showers_day
    this == Weather.Condition.MODERATE_RAIN_SHOWERS && isNight-> R.drawable.moderate_rain_showers_night
    this == Weather.Condition.MODERATE_RAIN_SHOWERS -> R.drawable.moderate_rain_showers_day
    this == Weather.Condition.VIOLENT_RAIN_SHOWERS && isNight-> R.drawable.violent_rain_showers_night
    this == Weather.Condition.VIOLENT_RAIN_SHOWERS -> R.drawable.violent_rain_showers_day
    this == Weather.Condition.SLIGHT_SNOW_SHOWERS && isNight-> R.drawable.slight_snow_fall_night
    this == Weather.Condition.SLIGHT_SNOW_SHOWERS -> R.drawable.slight_snow_fall_day
    this == Weather.Condition.HEAVY_SNOW_SHOWERS && isNight-> R.drawable.heavy_snow_showers_night
    this == Weather.Condition.HEAVY_SNOW_SHOWERS -> R.drawable.heavy_snow_showers_day
    this == Weather.Condition.SLIGHT_THUNDERSTORM && isNight-> R.drawable.thunderstorm_night
    this == Weather.Condition.SLIGHT_THUNDERSTORM -> R.drawable.thunderstorm_day
    this == Weather.Condition.MODERATE_THUNDERSTORM && isNight -> R.drawable.thunderstorm_night
    this == Weather.Condition.MODERATE_THUNDERSTORM -> R.drawable.thunderstorm_day
    this == Weather.Condition.SLIGHT_HAIL_THUNDERSTORM && isNight-> R.drawable.slight_hail_thunderstorm_night
    this == Weather.Condition.SLIGHT_HAIL_THUNDERSTORM -> R.drawable.slight_hail_thunderstorm_day
    this == Weather.Condition.HEAVY_HAIL_THUNDERSTORM && isNight-> R.drawable.heavy_hail_thunderstorm_night
    this == Weather.Condition.HEAVY_HAIL_THUNDERSTORM -> R.drawable.heavy_hail_thunderstorm_day
    else -> {
        R.drawable.clear_sky_day // Default to clear sky day if no match found
    }
}