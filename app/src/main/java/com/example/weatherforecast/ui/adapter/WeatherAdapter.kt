package com.example.weatherforecast.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ItemWeatherBinding
import com.example.weatherforecast.model.WeatherOrigin

class WeatherAdapter(private val weatherList: List<WeatherOrigin.List>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherAdapter.WeatherViewHolder {
        return WeatherViewHolder(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherAdapter.WeatherViewHolder, position: Int) {
        holder.bind(position, weatherList[position])
    }

    override fun getItemCount(): Int = weatherList.size

    inner class WeatherViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int, list: WeatherOrigin.List) {
            binding.tvPressure.text =
                "${itemView.context.getString(R.string.pressure)}${list.pressure}"
            binding.tvHumid.text =
                "${itemView.context.getString(R.string.humid)}${list.humidity} %"
            binding.tvDes.text =
                "${itemView.context.getString(R.string.des)}${list.weather[0].description} %"
        }
    }
}