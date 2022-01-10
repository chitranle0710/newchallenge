package com.example.weatherforecast.modules

import com.example.weatherforecast.util.Constant
import com.example.weatherforecast.ktor.KtorModule
import com.example.weatherforecast.model.ErrorCode
import com.example.weatherforecast.util.ResultWrapper
import com.example.weatherforecast.util.addCharAtIndex
import dagger.Provides
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.response.*
import io.ktor.http.*
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseMethod @Inject constructor(val ktorModule: KtorModule) {

    @Provides
    @Singleton
    suspend inline fun <reified T : Any> getMethod(city: String): ResultWrapper<T> {
        val httpResponse: HttpResponse =
            ktorModule.provideHttpKtor().get(Constant.URL.addCharAtIndex(city, 57))
        return try {
            if (httpResponse.status.isSuccess() || httpResponse.status.equals(Constant.SUCCESS_CODE)) {
                ResultWrapper.Success((httpResponse.receive()))
            } else {
                ResultWrapper.Error(ErrorCode(httpResponse.receive()))
            }
        } catch (e: Exception) {
            ResultWrapper.NetworkError(e)
        }
    }
}