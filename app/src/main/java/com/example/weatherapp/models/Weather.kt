package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(

    @SerializedName("main")
    var title: String = String(),

    @SerializedName("description")
    var description: String = String()

)