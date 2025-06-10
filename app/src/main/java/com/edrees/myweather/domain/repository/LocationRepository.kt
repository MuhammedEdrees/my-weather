package com.edrees.myweather.domain.repository

import com.edrees.myweather.domain.model.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}