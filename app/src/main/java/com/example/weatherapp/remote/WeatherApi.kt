package com.example.weatherapp.remote

import com.example.weatherapp.models.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getWeather(

        @Query("q")
        cityName: String,

        @Query("appid")
        apiKey: String = "37bff9c9645248cf0bb80de92d045bcc",

        @Query("units")
        units: String = "metric",

        ): Call<WeatherModel>

}