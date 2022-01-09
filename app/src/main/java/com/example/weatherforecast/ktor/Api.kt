package com.example.weatherforecast.ktor

import android.util.Log
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.util.ResultWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Api @Inject constructor() {
    // using Gson
    private val TIME_OUT = 60_000

    @Singleton
    @Provides
    fun provideHttpKtor() = HttpClient(Android) {
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

    @Singleton
    @Provides
    suspend fun fetchResult(city: String): ResultWrapper<WeatherOrigin> {
        return try {
            val httpResponse: HttpResponse =
                provideHttpKtor().get("https://api.openweathermap.org/data/2.5/forecast/daily?q=${city}&cnt=7&appid=60c6fbeb4b93ac653c492ba806fc346d")
            if (httpResponse.status.isSuccess() || httpResponse.status.equals(200)) {
                ResultWrapper.Success((httpResponse.receive()))
            } else ResultWrapper.Error(httpResponse.receive())
        } catch (ex: Exception) {
            Log.d("API-EXCEPTION", "$ex")
            ResultWrapper.Error(ex)
        }
    }

}