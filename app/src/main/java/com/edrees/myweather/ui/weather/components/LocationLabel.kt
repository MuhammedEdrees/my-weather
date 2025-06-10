package com.edrees.myweather.ui.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.theme.UrbanistFontFamily

@Composable
fun LocationLabel(
    modifier: Modifier = Modifier,
    cityName: String,
) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Icon(
            painter = painterResource(R.drawable.ic_location),
            contentDescription = null,
            tint = LocalCustomColors.current.textColor1,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = cityName,
            style = TextStyle(
                color = LocalCustomColors.current.textColor1,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.W500,
                fontFamily = UrbanistFontFamily
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationLabelPreview() {
    MyWeatherTheme {
        LocationLabel(
            cityName = "Baghdad"
        )
    }
}