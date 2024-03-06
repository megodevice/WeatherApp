package com.example.weatherapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class WeatherModel(

    @SerializedName("weather")
    var weather: ArrayList<Weather> = arrayListOf(),

    @SerializedName("main")
    var temp: Temp = Temp(),

    @SerializedName("visibility")
    var visibility: Int = 0,

    @SerializedName("wind")
    var wind: Wind = Wind(),

    @SerializedName("name")
    var name: String = String()

)