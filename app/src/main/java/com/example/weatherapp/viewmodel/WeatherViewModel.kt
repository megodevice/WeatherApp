package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.WeatherModel
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _weather: MutableLiveData<WeatherModel> = MutableLiveData()
    private val _message: MutableLiveData<String> = MutableLiveData()

    fun getWeather(cityName: String) {
        repository.getWeather(cityName, _message, _weather)
    }

    val weather: LiveData<WeatherModel> = _weather
    val message: LiveData<String> = _message
}