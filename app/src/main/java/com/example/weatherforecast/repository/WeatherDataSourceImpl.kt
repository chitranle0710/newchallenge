package com.example.weatherforecast.repository

import com.example.weatherforecast.modules.BaseMethod
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDataSourceImpl @Inject constructor(
    private val baseMethod: BaseMethod
) : WeatherDataSource {
    override suspend fun fetchData(city: String): ResultWrapper<WeatherOrigin> =
        baseMethod.getMethod(city)
}
