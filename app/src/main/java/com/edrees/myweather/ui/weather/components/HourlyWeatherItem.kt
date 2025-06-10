package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.domain.model.WeatherForecast
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.theme.UrbanistFontFamily
import com.edrees.myweather.ui.utils.formatHourMinute
import com.edrees.myweather.ui.utils.toDrawableRes
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun HourlyWeatherItem(
    modifier: Modifier = Modifier,
    hourlyWeather: WeatherForecast.HourlyForecast
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(LocalCustomColors.current.surfaceColor1)
                .border(
                    width = 1.dp,
                    color = LocalCustomColors.current.borderColor,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 62.dp,
                    start = 26.dp,
                    end = 26.dp,
                    bottom = 16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TemperatureText(
                    temperature = hourlyWeather.temperature,
                    temperatureUnit = Weather.Temperature.Unit.CELSIUS,
                    style = TextStyle(
                        fontFamily = UrbanistFontFamily,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.25.sp,
                        color = LocalCustomColors.current.textColor2
                    )
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = hourlyWeather.dateTime.formatHourMinute(),
                    style = TextStyle(
                        fontFamily = UrbanistFontFamily,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.25.sp,
                        color = LocalCustomColors.current.textColor3
                    )
                )
            }
        }

        Image(
            painter = painterResource(hourlyWeather.condition.toDrawableRes(isNight = hourlyWeather.isDay.not())),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(58.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HourlyWeatherItemPreview() {
    MyWeatherTheme {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(LocalCustomColors.current.backgroundColor1),
            contentAlignment = Alignment.Center
        ) {
            HourlyWeatherItem(
                hourlyWeather = WeatherForecast.HourlyForecast(
                    dateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
                    temperature = 31.0,
                    condition = Weather.Condition.CLEAR_SKY,
                )
            )
        }
    }
}