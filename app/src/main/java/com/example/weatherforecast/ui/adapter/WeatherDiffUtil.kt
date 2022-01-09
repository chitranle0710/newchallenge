package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherforecast.model.WeatherOrigin

class WeatherDiffUtil(
    private val oldList: List<WeatherOrigin.List>,
    private val newList: List<WeatherOrigin.List>,

    ) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].dt == newList[newItemPosition].dt
                && oldList[oldItemPosition].sunrise == newList[newItemPosition].sunrise
                && oldList[oldItemPosition].sunset == newList[newItemPosition].sunset
                && oldList[oldItemPosition].temp === newList[newItemPosition].temp
                && oldList[oldItemPosition].feels_like === newList[newItemPosition].feels_like
                && oldList[oldItemPosition].pressure == newList[newItemPosition].pressure
                && oldList[oldItemPosition].humidity == newList[newItemPosition].humidity
                && oldList[oldItemPosition].weather === newList[newItemPosition].weather
                && oldList[oldItemPosition].speed == newList[newItemPosition].speed
                && oldList[oldItemPosition].deg == newList[newItemPosition].deg
                && oldList[oldItemPosition].gust == newList[newItemPosition].gust
                && oldList[oldItemPosition].clouds == newList[newItemPosition].clouds
                && oldList[oldItemPosition].pop == newList[newItemPosition].pop
                && oldList[oldItemPosition].rain == newList[newItemPosition].rain


    }

}