package com.example.weatherforecast

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.ui.adapter.BaseActivity
import com.example.weatherforecast.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchData("saigon")
        viewModel.weatherLiveData.observe(this) {
            Log.d("MainActivity", "$it")
        }
    }

}
