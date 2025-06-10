package com.edrees.myweather.ui.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edrees.myweather.domain.repository.LocationRepository
import com.edrees.myweather.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val locationRepository: LocationRepository,
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getCurrentLocation()
    }

    private fun getCurrentLocation() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                locationRepository.getCurrentLocation()
            }.onSuccess { location ->
                    _uiState.update { oldState ->
                        oldState.copy(currentLocation = location, errorMessage = null)
                    }
                    fetchWeatherForecast()
                }.onFailure { error ->
                    Log.e(WeatherViewModel::class.simpleName, "Error fetching current location", error)
                    _uiState.update { oldState ->
                        oldState.copy(
                            isLoading = false,
                            errorMessage = error.message
                        )
                    }
                }
            }
        }

    private fun fetchWeatherForecast() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                weatherRepository.getWeatherForecastByLocation(
                    uiState.value.currentLocation
                )
            }.onSuccess { forecast ->
                Log.d(WeatherViewModel::class.simpleName, "fetchWeatherForecast: $forecast")
                _uiState.update { oldState ->
                    oldState.copy(isLoading = false, weatherForecast = forecast, errorMessage = null)
                }
            }.onFailure { error ->
                Log.e(WeatherViewModel::class.simpleName, "Error fetching weather forecast", error)
                _uiState.update { oldState ->
                    oldState.copy(
                        isLoading = false,
                        errorMessage = error.message
                    )
                }
            }
        }
    }
}