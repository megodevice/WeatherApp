package com.example.weatherapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.models.WeatherModel
import com.example.weatherapp.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val api: WeatherApi,
) {

    fun getWeather(
        cityName: String,
        message: MutableLiveData<String>,
        weather: MutableLiveData<WeatherModel>
    ) {
        api.getWeather(cityName).enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        weather.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                message.postValue(t.localizedMessage)
            }

        })
    }

}