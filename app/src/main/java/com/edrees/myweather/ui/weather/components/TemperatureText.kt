package com.edrees.myweather.ui.weather.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.util.fastRoundToInt
import com.edrees.myweather.domain.model.Weather

@Composable
fun TemperatureText(
    modifier: Modifier = Modifier,
    temperature: Double,
    temperatureUnit: Weather.Temperature.Unit,
    style: TextStyle
) {
    Text(
        modifier = modifier,
        text = "${temperature.fastRoundToInt()}${temperatureUnit.symbol}",
        style = style
    )
}