package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.myweather.R
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.domain.model.WeatherForecast
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.theme.UrbanistFontFamily
import kotlinx.datetime.LocalDate

@Composable
fun DailyWeatherSection(
    modifier: Modifier = Modifier,
    dailyForecasts: List<WeatherForecast.DailyForecast>
) {
    Column (
        modifier = modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.next_7_days),
            style = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = LocalCustomColors.current.textColor1
            )
        )
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(color = LocalCustomColors.current.surfaceColor1)
                .border(
                    width = 1.dp,
                    color = LocalCustomColors.current.borderColor,
                    shape = RoundedCornerShape(24.dp)
                )
                .wrapContentHeight()
        ){
            dailyForecasts.forEachIndexed { index, dailyWeather ->
                DailyWeatherItem(
                    dailyWeather = dailyWeather,
                    isDividerVisible = index != dailyForecasts.lastIndex
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_9_pro")
@Composable
private fun DailyWeatherSectionPreview() {
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
            condition = Weather.Condition.PARTLY_CLOUDY,
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
    MyWeatherTheme {
        Box(modifier = Modifier.background(Color.DarkGray)) {
            DailyWeatherSection(

                dailyForecasts = weeklyForecast
            )
        }
    }
}