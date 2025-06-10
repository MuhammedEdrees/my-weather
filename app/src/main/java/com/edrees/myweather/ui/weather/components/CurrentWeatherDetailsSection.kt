package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastRoundToInt
import com.edrees.myweather.R
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.ui.theme.MyWeatherTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CurrentWeatherDetailsSection(
    modifier: Modifier = Modifier,
    currentWeather: Weather
) {
    FlowRow (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ){
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_wind),
            value = "${currentWeather.wind.speed.fastRoundToInt()} ${currentWeather.wind.unit.symbol}",
            description = stringResource(R.string.wind)
        )
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_humidity),
            value = "${currentWeather.humidityPercentage}%",
            description = stringResource(R.string.humidity)
        )
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_rain),
            value = "${currentWeather.precipitation.rainProbability}%",
            description = stringResource(R.string.rain)
        )
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_uv),
            value = "${currentWeather.uvIndex.fastRoundToInt()}",
            description = stringResource(R.string.uv_index)
        )
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_pressure),
            value = "${currentWeather.pressure.value.fastRoundToInt()} ${currentWeather.pressure.unit.symbol}",
            description = stringResource(R.string.pressure)
        )
        WeatherDetailItem(
            modifier = Modifier.weight(1f),
            iconPainter = painterResource(R.drawable.ic_temperature),
            value = "${currentWeather.temperature.feelsLike.fastRoundToInt()} ${currentWeather.temperature.unit.symbol}",
            description = stringResource(R.string.feels_like)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_9_pro")
@Composable
private fun CurrentWeatherDetailsPreview() {
    MyWeatherTheme {
        CurrentWeatherDetailsSection(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 40.dp),
            currentWeather = Weather()
        )
    }
}