package com.example.weatherforecast.model

import com.google.gson.annotations.SerializedName

class ErrorCode(
    @SerializedName("cod")
    val cod: Int = 0,
    @SerializedName("message")
    val message: String? = null
) {
}