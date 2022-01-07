package com.example.weatherforecast.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ceil

object Convert {
    fun convertKelvinToCelsius(max: Double, min: Double): Int {
        val avgKelvin = (max + min) / 2.0
        return ceil(avgKelvin - 273.15).toInt()
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val date = Date(time * 1000)
        val format = SimpleDateFormat("EEE, dd MMM yyyy")
        return format.format(date)
    }
}