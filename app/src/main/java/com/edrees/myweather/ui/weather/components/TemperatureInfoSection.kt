package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.myweather.R
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.LocalThemeInfo
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.theme.UrbanistFontFamily
import com.edrees.myweather.ui.utils.titleRes
import com.edrees.myweather.ui.utils.toDrawableRes

@Composable
fun TemperatureInfoSection(
    modifier: Modifier = Modifier,
    temperature: Weather.Temperature,
    weatherCondition: Weather.Condition
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TemperatureText(
            temperature = temperature.current,
            temperatureUnit = temperature.unit,
            style = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontSize = 64.sp,
                fontWeight = FontWeight.W600,
                color = LocalCustomColors.current.textColor1,
                letterSpacing = 0.25.sp,
                lineHeight = 64.sp
            )
        )
        Text(
            text = stringResource(weatherCondition.titleRes),
            style = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.W500,
                color = LocalCustomColors.current.textColor3,
                letterSpacing = 0.25.sp
            )
        )
        Row (
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .background(
                    color = LocalCustomColors.current.surfaceColor2,
                    shape = RoundedCornerShape(100.dp)
                ).padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.ic_arrow_up),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = LocalCustomColors.current.textColor3
            )
            TemperatureText(
                modifier = Modifier.padding(start = 4.dp),
                temperature = temperature.high,
                temperatureUnit = temperature.unit,
                style = TextStyle(
                    fontFamily = UrbanistFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = LocalCustomColors.current.textColor3,
                    letterSpacing = 0.25.sp,
                    lineHeight = 16.sp
                )
            )
            VerticalDivider(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .height(14.dp),
                thickness = 1.dp,
                color = LocalCustomColors.current.dividerColor,
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(12.dp),
                tint = LocalCustomColors.current.textColor3
            )
            TemperatureText(
                modifier = Modifier.padding(start = 4.dp),
                temperature = temperature.low,
                temperatureUnit = temperature.unit,
                style = TextStyle(
                    fontFamily = UrbanistFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = LocalCustomColors.current.textColor3,
                    letterSpacing = 0.25.sp,
                    lineHeight = 16.sp
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TemperatureInfoSectionPreview() {
    MyWeatherTheme {
        TemperatureInfoSection(
            modifier = Modifier.width(168.dp),
            temperature = Weather.Temperature(
                current = 24.0,
                high = 32.0,
                low = 20.0,
                feelsLike = 27.0,
                unit = Weather.Temperature.Unit.CELSIUS
            ),
            weatherCondition = Weather.Condition.PARTLY_CLOUDY
        )
    }
}
