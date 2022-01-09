package com.example.weatherforecast.repository

import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun fetchData(city: String): Flow<ResultWrapper<WeatherOrigin>>
}