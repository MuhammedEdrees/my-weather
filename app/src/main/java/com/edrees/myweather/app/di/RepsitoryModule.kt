package com.edrees.myweather.app.di

import android.location.Geocoder
import android.system.Os.bind
import com.edrees.myweather.data.repository.LocationRepositoryImpl
import com.edrees.myweather.data.repository.WeatherRepositoryImpl
import com.edrees.myweather.domain.repository.LocationRepository
import com.edrees.myweather.domain.repository.WeatherRepository
import com.google.android.gms.location.LocationServices
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import java.util.Locale

val repositoryModule = module {
    singleOf(::LocationRepositoryImpl) { bind<LocationRepository>() }
    singleOf(::WeatherRepositoryImpl) { bind<WeatherRepository>() }
    single {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }
    single {
        Geocoder(androidContext(), Locale.ENGLISH)
    }
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                        isLenient = true
                        encodeDefaults = true
                    }
                )
            }
        }
    }
}