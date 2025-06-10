package com.edrees.myweather.ui.weather.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edrees.myweather.domain.model.Weather
import com.edrees.myweather.ui.theme.MyWeatherTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun WeatherTopBar(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean,
    cityName: String,
    weatherCondition: Weather.Condition,
    currentTemperature: Weather.Temperature,
    isDay: Boolean,
) {
    SharedTransitionLayout(modifier = modifier) {
        AnimatedContent(
            targetState = isCollapsed,
            transitionSpec = {
                scaleIn(
                    animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
                ) togetherWith scaleOut(
                    animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                ).apply {
                    SizeTransform(
                        clip = true,
                        sizeAnimationSpec = { _, _ -> tween(durationMillis = 1000, easing = LinearOutSlowInEasing) }
                    )
                }
            }
        ) { targetState ->
            if (targetState) {
                CollapsedTopBar(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedContent,
                    isDay = isDay,
                    weatherCondition = weatherCondition,
                    cityName = cityName,
                    currentTemperature = currentTemperature
                )
            } else {
                ExpandedTopBar(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedContent,
                    isDay = isDay,
                    weatherCondition = weatherCondition,
                    cityName = cityName,
                    currentTemperature = currentTemperature
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun CollapsedTopBar(
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedContentScope,
    cityName: String,
    weatherCondition: Weather.Condition,
    isDay: Boolean,
    currentTemperature: Weather.Temperature
) {
    with(sharedTransitionScope) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocationLabel(
                modifier = Modifier.sharedBounds(
                    rememberSharedContentState(key = LOCATION_LABEL_KEY),
                    animatedVisibilityScope = animatedVisibilityScope
                ),cityName = cityName)
            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CurrentTemperatureIcon(
                    modifier = Modifier.sharedBounds(
                        rememberSharedContentState(key = CONDITION_ICON_KEY),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                    size = 112.dp,
                    isDay = isDay,
                    weatherCondition = weatherCondition
                )
                TemperatureInfoSection(
                    modifier = Modifier
                        .width(168.dp)
                        .sharedBounds(
                            rememberSharedContentState(key = TEMPERATURE_INFO_KEY),
                            animatedVisibilityScope = animatedVisibilityScope
                        ),
                    temperature = currentTemperature,
                    weatherCondition = weatherCondition
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun ExpandedTopBar(
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedContentScope,
    cityName: String,
    weatherCondition: Weather.Condition,
    isDay: Boolean,
    currentTemperature: Weather.Temperature
) {
    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            LocationLabel(
                modifier = Modifier.sharedBounds(
                    rememberSharedContentState(key = LOCATION_LABEL_KEY),
                    animatedVisibilityScope = animatedVisibilityScope
                ),cityName = cityName)
            CurrentTemperatureIcon(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .sharedBounds(
                    rememberSharedContentState(key = CONDITION_ICON_KEY),
                    animatedVisibilityScope = animatedVisibilityScope
                ),
                size = 200.dp,
                isDay = isDay,
                weatherCondition = weatherCondition
            )
            TemperatureInfoSection(
                modifier = Modifier
                    .padding(top = 248.dp)
                    .width(168.dp)
                    .sharedBounds(
                        rememberSharedContentState(key = TEMPERATURE_INFO_KEY),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                temperature = currentTemperature,
                weatherCondition = weatherCondition
            )
        }
    }
}

private val CONDITION_ICON_KEY = "condition_icon_key"
private val LOCATION_LABEL_KEY = "location_label_key"
private val TEMPERATURE_INFO_KEY = "temperature_info_key"


@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_9_pro")
@Composable
private fun WeatherTopBarPreview() {
    MyWeatherTheme {
        var isCollapsed by remember { mutableStateOf(false) }
        LaunchedEffect (Unit){
            delay(2000)
            isCollapsed = false
        }
        WeatherTopBar(
            isCollapsed = isCollapsed,
            cityName = "San Francisco",
            weatherCondition = Weather.Condition.CLEAR_SKY,
            currentTemperature = Weather.Temperature(
                current = 20.0,
                high = 25.0,
                low = 15.0,
                feelsLike = 18.0,
                unit = Weather.Temperature.Unit.CELSIUS
            ),
            isDay = true
        )
    }
}