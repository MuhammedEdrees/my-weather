package com.edrees.myweather.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.domain.model.WeatherForecast
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.weather.components.CurrentWeatherDetailsSection
import com.edrees.myweather.ui.weather.components.DailyWeatherSection
import com.edrees.myweather.ui.weather.components.HourlyWeatherSection
import com.edrees.myweather.ui.weather.components.WeatherTopBar
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

@Composable
fun WeatherScreenContent(
    modifier: Modifier = Modifier,
    state: WeatherUiState,
) {
    val scrollState = rememberScrollState()
    val isCollapsed by remember {
        derivedStateOf {
            val isScrollable = scrollState.maxValue > 0
            scrollState.value > 0 || !isScrollable
        }
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        LocalCustomColors.current.backgroundColor1,
                        LocalCustomColors.current.backgroundColor2
                    )
                )
            )
            .windowInsetsPadding(WindowInsets.systemBars),
        containerColor = Color.Transparent,
        topBar = {
            WeatherTopBar(
                modifier = Modifier.padding(top = 24.dp, start = 12.dp, end = 12.dp),
                isCollapsed = isCollapsed,
                weatherCondition = state.weatherForecast.currentWeather.condition,
                currentTemperature = state.weatherForecast.currentWeather.temperature,
                cityName = state.currentLocation.cityName,
                isDay = state.weatherForecast.currentWeather.isDay
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(top = 16.dp)
                .verticalScroll(scrollState),
        ) {
            CurrentWeatherDetailsSection(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                currentWeather = state.weatherForecast.currentWeather
            )
            HourlyWeatherSection(
                modifier = Modifier.padding(top = 24.dp),
                hourlyForecasts = state.weatherForecast.hourlyForecasts
            )
            DailyWeatherSection(
                modifier = Modifier.padding(top = 24.dp),
                dailyForecasts = state.weatherForecast.dailyForecasts
            )
        }
    }

}


@Preview(
    showSystemUi = true, showBackground = true,
    device = "spec:width=1280dp,height=800dp,dpi=240",
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
private fun WeatherScreenContentPreview() {
    val weeklyForecast = listOf(
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 10),
            highTemperature = 28.5,
            lowTemperature = 18.2,
            condition = Weather.Condition.CLEAR_SKY,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 11),
            highTemperature = 31.0,
            lowTemperature = 20.1,
            condition = Weather.Condition.MAINLY_CLEAR,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 12),
            highTemperature = 26.8,
            lowTemperature = 17.5,
            condition = Weather.Condition.OVERCAST,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 13),
            highTemperature = 24.2,
            lowTemperature = 16.0,
            condition = Weather.Condition.SLIGHT_RAIN,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 14),
            highTemperature = 22.5,
            lowTemperature = 14.8,
            condition = Weather.Condition.MODERATE_THUNDERSTORM,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 15),
            highTemperature = 25.3,
            lowTemperature = 16.5,
            condition = Weather.Condition.PARTLY_CLOUDY,
        ),
        WeatherForecast.DailyForecast(
            date = LocalDate(2025, 6, 16),
            highTemperature = 29.1,
            lowTemperature = 19.7,
            condition = Weather.Condition.CLEAR_SKY,
        )
    )
    val sampleWeatherForecast = listOf(
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 14, 0), // Today 2:00 PM
            temperature = 28.5,
            condition = Weather.Condition.CLEAR_SKY
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 15, 0), // Today 3:00 PM
            temperature = 30.2,
            condition = Weather.Condition.MAINLY_CLEAR
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 16, 0), // Today 4:00 PM
            temperature = 31.8,
            condition = Weather.Condition.OVERCAST
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 17, 0), // Today 5:00 PM
            temperature = 29.7,
            condition = Weather.Condition.HEAVY_RAIN
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 18, 0), // Today 6:00 PM
            temperature = 26.3,
            condition = Weather.Condition.MODERATE_THUNDERSTORM
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 19, 0), // Today 7:00 PM
            temperature = 24.1,
            condition = Weather.Condition.MODERATE_RAIN
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 20, 0), // Today 8:00 PM
            temperature = 22.9,
            condition = Weather.Condition.PARTLY_CLOUDY
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 21, 0), // Today 9:00 PM
            temperature = 21.5,
            condition = Weather.Condition.PARTLY_CLOUDY
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 22, 0), // Today 10:00 PM
            temperature = 20.8,
            condition = Weather.Condition.FOG
        ),
        WeatherForecast.HourlyForecast(
            dateTime = LocalDateTime(2025, 6, 10, 23, 0), // Today 11:00 PM
            temperature = 19.6,
            condition = Weather.Condition.CLEAR_SKY
        )
    )
    val currentWeather = Weather(
        temperature = Weather.Temperature(
            current = 28.5,
            unit = Weather.Temperature.Unit.CELSIUS,
            feelsLike = 30.0
        ),
        condition = Weather.Condition.CLEAR_SKY,
        wind = Weather.Wind(speed = 15.0, unit = Weather.Wind.Unit.KMH),
        humidityPercentage = 60,
        precipitation = Weather.Precipitation(rainProbability = 10, amount = 0.0),
        uvIndex = 5.0,
        pressure = Weather.AtmosphericPressure(
            value = 1013.0,
            unit = Weather.AtmosphericPressure.Unit.HPA
        )
    )
    MyWeatherTheme {
        WeatherScreenContent(
            state = WeatherUiState(
                weatherForecast = WeatherForecast(
                    currentWeather = currentWeather,
                    dailyForecasts = weeklyForecast,
                    hourlyForecasts = sampleWeatherForecast
                )
            )
        )
    }
}