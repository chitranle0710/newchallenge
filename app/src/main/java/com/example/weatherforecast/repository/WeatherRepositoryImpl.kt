package com.example.weatherforecast.repository

import com.example.weatherforecast.ktor.Api
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor() : WeatherRepository {
    override suspend fun fetchData(city: String): ResultWrapper<WeatherOrigin> =
       Api.fetchResult(city)
}