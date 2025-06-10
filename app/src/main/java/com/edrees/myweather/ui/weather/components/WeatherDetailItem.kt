package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.myweather.ui.theme.LightBlue1
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.theme.UrbanistFontFamily

@Composable
fun WeatherDetailItem(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    value: String,
    description: String
) {
    Column (
        modifier = modifier
            .widthIn(min = 108.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(LocalCustomColors.current.surfaceColor1)
            .border(
                width = 1.dp,
                color = LocalCustomColors.current.borderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            painter = iconPainter,
            contentDescription = null,
            tint = LightBlue1,
            modifier = Modifier.size(32.dp)
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = value,
            style = TextStyle(
                color = LocalCustomColors.current.textColor2,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.W500,
                fontFamily = UrbanistFontFamily
            )
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = description,
            style = TextStyle(
                color = LocalCustomColors.current.textColor3,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.W400,
                fontFamily = UrbanistFontFamily
            )
        )
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true,)
@Composable
private fun WeatherDetailItemPreview() {
    MyWeatherTheme {
        Row(modifier = Modifier.background(Color.Black)) {
            WeatherDetailItem(
                modifier = Modifier.width(108.dp),
                iconPainter = painterResource(id = com.edrees.myweather.R.drawable.ic_wind),
                value = "13 KM/h",
                description = "Wind"
            )
            WeatherDetailItem(
                modifier = Modifier.width(108.dp),
                iconPainter = painterResource(id = com.edrees.myweather.R.drawable.ic_wind),
                value = "13 KM/h",
                description = "Wind"
            )
            WeatherDetailItem(
                modifier = Modifier.width(108.dp),
                iconPainter = painterResource(id = com.edrees.myweather.R.drawable.ic_wind),
                value = "13 KM/h",
                description = "Wind"
            )
            Spacer(modifier = Modifier.size(36.dp))
        }
    }
}