package com.edrees.myweather.ui.weather.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.ui.theme.LocalCustomColors
import com.edrees.myweather.ui.theme.LocalThemeInfo
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.utils.toDrawableRes

@Composable
fun CurrentTemperatureIcon(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    weatherCondition: Weather.Condition,
    isDay: Boolean = true
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        BlurredCircle(
            size = size* 1.25f,
            color = LocalCustomColors.current.backgroundColor3
        )
        Image(
            painter = painterResource(weatherCondition.toDrawableRes(isNight = isDay.not())),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.height(size)
        )
    }
}


@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
private fun CurrentTemperatureIconPreview() {
    MyWeatherTheme {
        Box(modifier = Modifier.size(300.dp).background(LocalCustomColors.current.backgroundColor1),
            contentAlignment = Alignment.Center
        ) {
            CurrentTemperatureIcon(
                weatherCondition = Weather.Condition.MAINLY_CLEAR
            )
        }
    }
}