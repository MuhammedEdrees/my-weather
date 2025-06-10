package com.edrees.myweather.data.repository

import android.annotation.SuppressLint
import android.location.Geocoder
import com.edrees.myweather.domain.model.Location
import com.edrees.myweather.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.tasks.await

@SuppressLint("MissingPermission")
class LocationRepositoryImpl(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val geocoder: Geocoder
) : LocationRepository {
    override suspend fun getCurrentLocation(): Location {
        val location = fusedLocationProviderClient.lastLocation.await()
        return location?.let {
            val addresses = geocoder.getFromLocation(
                location.latitude,
                location.longitude,
                1
            )

            val cityName = addresses?.firstOrNull()?.locality
                ?: addresses?.firstOrNull()?.subAdminArea
                ?: "Unknown City"

            Location(cityName, location.longitude, location.latitude)
        } ?: throw IllegalStateException("No location available")
    }
}
