package com.example.weatherforecast.repository

import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper


interface WeatherDataSource {
    suspend fun fetchData(city: String): ResultWrapper<WeatherOrigin>
}