package com.example.weatherforecast

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.databinding.ActivityMainBinding
import com.example.weatherforecast.model.WeatherOrigin
import com.example.weatherforecast.ui.adapter.BaseActivity
import com.example.weatherforecast.ui.adapter.WeatherAdapter
import com.example.weatherforecast.util.onClick
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

        registerObserver()
        onClick()
    }

    private fun onClick() {
        binding.tvSearch.onClick {
            viewModel.fetchData("saigon")
        }
    }

    private fun registerObserver() {
        viewModel.weatherLiveData.observe(this) {
            initRecyclerView(it.list)
        }
        viewModel.loadingData.observe(this) {
            progressBar(it)
        }
    }

    private fun initRecyclerView(listWeather: List<WeatherOrigin.List>?) {
        listWeather ?: return
        val adapter = WeatherAdapter(listWeather)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvWeather.layoutManager = layoutManager
        binding.rvWeather.setHasFixedSize(true)
        binding.rvWeather.adapter = adapter
    }
}
