package com.example.weatherforecast

import com.example.weatherforecast.util.Convert
import junit.framework.Assert.assertEquals
import org.junit.Test


class WeatherTest {
    @Test
    fun isCorrectDegree() {
        assertEquals(25.0, Convert.convertKelvinToCelsius(250.0, 280.0))
    }
}