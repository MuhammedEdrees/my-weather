package com.edrees.myweather.app.di

import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule, repositoryModule)
}