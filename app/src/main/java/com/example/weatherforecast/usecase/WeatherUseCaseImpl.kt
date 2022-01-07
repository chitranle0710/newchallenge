package com.example.weatherforecast.usecase

import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.repository.WeatherRepository
import com.example.weatherforecast.util.ResultWrapper

class WeatherUseCaseImpl(private val repository: WeatherRepository) :
    WeatherUseCase {
    override suspend fun fetchData(): ResultWrapper<WeatherOrigin> = repository.fetchData()

}