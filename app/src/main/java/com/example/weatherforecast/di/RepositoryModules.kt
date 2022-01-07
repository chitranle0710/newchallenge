package com.example.weatherforecast.di

import com.example.weatherforecast.repository.WeatherRepository
import com.example.weatherforecast.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModules {
    @Binds
    fun provideFilmRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository
}