package com.example.weatherforecast.usecase

import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface WeatherUseCase {
    suspend fun fetchData(city: String): Flow<ResultWrapper<WeatherOrigin>>
}