package com.example.weatherforecast.util

import com.example.weatherforecast.model.ErrorCode

sealed class ResultWrapper<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultWrapper<T>()
    data class Error(val error: ErrorCode) : ResultWrapper<Nothing>()
    data class NetworkError(val exception: Exception) : ResultWrapper<Nothing>()

}