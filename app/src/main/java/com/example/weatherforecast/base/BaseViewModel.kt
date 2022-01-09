package com.example.weatherforecast.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {
    val execute = SupervisorJob()


    override fun onCleared() {
        super.onCleared()
    }

}