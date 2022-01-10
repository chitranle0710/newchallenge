package com.example.weatherforecast.repository

import android.util.Log
import com.example.weatherforecast.ktor.Constant
import com.example.weatherforecast.ktor.KtorModule
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import com.example.weatherforecast.util.addCharAtIndex
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDataSourceImpl @Inject constructor(
    private val ktor: KtorModule
) : WeatherDataSource {
    override suspend fun fetchData(city: String): ResultWrapper<WeatherOrigin> =
        try {
            val url = Constant.URL.addCharAtIndex(city, 57)
            val httpResponse: HttpResponse =
                ktor.provideHttpKtor().get(url)
            if (httpResponse.status.isSuccess() || httpResponse.status.equals(200)) {
                ResultWrapper.Success((httpResponse.receive()))
            } else ResultWrapper.Error(httpResponse.receive())
        } catch (ex: Exception) {
            Log.d("API-EXCEPTION", "$ex")
            ResultWrapper.Error(ex)
        }
}
