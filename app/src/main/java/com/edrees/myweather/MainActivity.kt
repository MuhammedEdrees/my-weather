package com.edrees.myweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.edrees.myweather.ui.theme.MyWeatherTheme
import com.edrees.myweather.ui.weather.WeatherScreenContent
import com.edrees.myweather.ui.weather.WeatherViewModel
import org.koin.android.ext.android.getKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        val weatherViewModel = getKoin().get<WeatherViewModel>()
        enableEdgeToEdge()
        setContent {
            val state by weatherViewModel.uiState.collectAsState()
            splashScreen.setKeepOnScreenCondition {
                state.isLoading
            }
            if(!state.isLoading) {
                MyWeatherTheme(
                    darkTheme = state.weatherForecast.currentWeather.isDay.not()
                ) {
                    WeatherScreenContent(state = state)
                }
            }
        }
    }
}