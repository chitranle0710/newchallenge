package com.example.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class WeatherOrigin(
    @SerializedName("city")
    var city: City? = null,
    @SerializedName("cod")
    var cod: String? = null,
    @SerializedName("message")
    var message: Double = 0.0,
    @SerializedName("cnt")
    var cnt: Int = 0,
    @SerializedName("list")
    var list: kotlin.collections.List<List>? = null
) {
    class City(
        var id: Int = 0,
        var name: String? = null,
        var coord: Coord? = null,
        var country: String? = null,
        var population: Int = 0,
        var timezone: Int = 0
    ) {

        class Coord(
            var lon: Double = 0.0,
            var lat: Double = 0.0
        )
    }

    data class List(
        @SerializedName("dt")
        var dt: Int = 0,
        @SerializedName("sunrise")
        var sunrise: Int = 0,
        @SerializedName("sunset")
        var sunset: Int = 0,
        @SerializedName("temp")
        var temp: Temp? = null,
        @SerializedName("feels_like")
        var feels_like: FeelsLike? = null,
        @SerializedName("pressure")
        var pressure: Int = 0,
        @SerializedName("humidity")
        var humidity: Int = 0,
        @SerializedName("weather")
        var weather: kotlin.collections.List<Weather>? = null,
        @SerializedName("speed")
        var speed: Double = 0.0,
        @SerializedName("deg")
        var deg: Int = 0,
        @SerializedName("gust")
        var gust: Double = 0.0,
        @SerializedName("clouds")
        var clouds: Int = 0,
        @SerializedName("pop")
        var pop: Double = 0.0,
        @SerializedName("rain")
        var rain: Double = 0.0
    ) {
        class FeelsLike(
            var day: Double = 0.0,
            var night: Double = 0.0,
            var eve: Double = 0.0,
            var morn: Double = 0.0
        )

        data class Temp(
            @SerializedName("day")
            var day: Double = 0.0,
            @SerializedName("min")
            var min: Double = 0.0,
            @SerializedName("max")
            var max: Double = 0.0,
            @SerializedName("night")
            var night: Double = 0.0,
            @SerializedName("eve")
            var eve: Double = 0.0,
            @SerializedName("morn")
            var morn: Double = 0.0
        )

        data class Weather(
            @SerializedName("id")
            var id: Int = 0,
            @SerializedName("main")
            var main: String? = null,
            @SerializedName("description")
            var description: String? = null,
            @SerializedName("icon")
            var icon: String? = null
        )

    }

}







