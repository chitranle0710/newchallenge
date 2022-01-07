package com.example.weatherforecast.usecase

import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper

interface WeatherUseCase {
    suspend fun fetchData(city: String): ResultWrapper<WeatherOrigin>
}