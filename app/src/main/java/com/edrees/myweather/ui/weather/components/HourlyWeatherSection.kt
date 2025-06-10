package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.myweather.R
import com.edrees.myweather.domain.model.WeatherForecast
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.UrbanistFontFamily

@Composable
fun HourlyWeatherSection(
    modifier: Modifier = Modifier,
    hourlyForecasts: List<WeatherForecast.HourlyForecast>
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(R.string.today),
            style = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                color = LocalCustomColors.current.textColor1
            )
        )
        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(
                items = hourlyForecasts
            ){ hourlyWeather ->
                HourlyWeatherItem(
                    hourlyWeather = hourlyWeather
                )
            }
        }
    }
}