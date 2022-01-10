package com.example.weatherforecast.modules

import com.example.weatherforecast.repository.WeatherDataSource
import com.example.weatherforecast.repository.WeatherDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModules {
    @Binds
    fun provideWeatherDataSource(
        dataSourceImpl: WeatherDataSourceImpl
    ): WeatherDataSource
}