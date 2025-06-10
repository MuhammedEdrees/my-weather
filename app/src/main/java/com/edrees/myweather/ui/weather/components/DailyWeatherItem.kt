package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.edrees.myweather.ui.utils.formatDayName
import com.edrees.myweather.ui.utils.toDrawableRes
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun DailyWeatherItem(
    modifier: Modifier = Modifier,
    dailyWeather: WeatherForecast.DailyForecast,
    isDividerVisible: Boolean,
) {
    Column(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = dailyWeather.date.formatDayName(),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = UrbanistFontFamily,
                    letterSpacing = 0.25.sp,
                    color = LocalCustomColors.current.textColor3
                )
            )
            Image(
                painter = painterResource(dailyWeather.condition.toDrawableRes(isNight = false)),
                contentDescription = null,
//                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 7.dp, bottom = 6.dp)
                    .height(32.dp),
            )
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_up),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp),
                    tint = LocalCustomColors.current.textColor2
                )
                TemperatureText(
                    modifier = Modifier.padding(start = 4.dp),
                    temperature = dailyWeather.highTemperature,
                    temperatureUnit = Weather.Temperature.Unit.CELSIUS,
                    style = TextStyle(
                        fontFamily = UrbanistFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = LocalCustomColors.current.textColor2,
                        letterSpacing = 0.25.sp,
                        lineHeight = 14.sp
                    )
                )
                VerticalDivider(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .height(14.dp),
                    thickness = 1.dp,
                    color = LocalCustomColors.current.dividerColor,
                )
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_down),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .size(12.dp),
                    tint = LocalCustomColors.current.textColor2
                )
                TemperatureText(
                    modifier = Modifier.padding(start = 4.dp),
                    temperature = dailyWeather.lowTemperature,
                    temperatureUnit = Weather.Temperature.Unit.CELSIUS,
                    style = TextStyle(
                        fontFamily = UrbanistFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = LocalCustomColors.current.textColor2,
                        letterSpacing = 0.25.sp,
                        lineHeight = 14.sp
                    )
                )
            }
        }
        if (isDividerVisible) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = LocalCustomColors.current.borderColor
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_5")
@Composable
private fun DailyWeatherItemPreview() {
    MyWeatherTheme {
        Box(modifier = Modifier.padding(top = 40.dp)) {
            DailyWeatherItem(
                modifier = Modifier.padding(horizontal = 12.dp),
                dailyWeather = WeatherForecast.DailyForecast(
                    date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date,
                    highTemperature = 31.0,
                    lowTemperature = 21.0,
                    condition = Weather.Condition.OVERCAST,
                ),
                isDividerVisible = true
            )
        }
    }
}