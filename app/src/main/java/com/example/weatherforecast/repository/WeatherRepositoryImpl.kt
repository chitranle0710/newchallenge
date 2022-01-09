package com.example.weatherforecast.repository

import com.example.weatherforecast.ktor.Api
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(private val api: Api) : WeatherRepository {
    override suspend fun fetchData(city: String): Flow<ResultWrapper<WeatherOrigin>> = flow {
        val response = api.fetchResult(city)
        emit(response)
    }

}