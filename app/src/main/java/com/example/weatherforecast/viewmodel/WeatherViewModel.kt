package com.example.weatherforecast.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.base.BaseViewModel
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.usecase.WeatherUseCase
import com.example.weatherforecast.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase) :
    BaseViewModel() {
    val weatherLiveData = MutableLiveData<WeatherOrigin>()
    val loadingData = MutableLiveData<Boolean>()

    fun fetchData(city: String) {
        loadingData.postValue(true)
        viewModelScope.launch {
            val response = weatherUseCase.fetchData(city)
            response.collect {
                when (it) {
                    is ResultWrapper.Success -> {
                        weatherLiveData.postValue(it.data)
                        loadingData.postValue(false)
                    }
                    is ResultWrapper.Error -> {
                        loadingData.postValue(false)
                    }
                }
                loadingData.postValue(false)
            }
        }

    }
}
