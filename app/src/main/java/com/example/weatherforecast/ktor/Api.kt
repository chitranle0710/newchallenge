package com.example.weatherforecast.ktor

import android.util.Log
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import java.lang.Exception

object Api {
    // using Gson
    const val URL = "https://ghibliapi.herokuapp.com"
    private const val TIME_OUT = 60_000

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }
        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
    }

    suspend fun fetchResult(): ResultWrapper<WeatherOrigin> {
        return try {
            val httpResponse: HttpResponse = client.get("")
            if (httpResponse.status.isSuccess() || httpResponse.status.equals(200)) {
                ResultWrapper.Success((httpResponse.receive()))
            } else ResultWrapper.Error(httpResponse.receive())
        } catch (ex: Exception) {
            Log.d("API-EXCEPTION", "$ex")
            ResultWrapper.Error(ex)
        }
    }

}