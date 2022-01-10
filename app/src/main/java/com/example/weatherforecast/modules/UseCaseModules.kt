package com.example.weatherforecast.modules

import com.example.weatherforecast.repository.WeatherRepository
import com.example.weatherforecast.usecase.WeatherUseCase
import com.example.weatherforecast.usecase.WeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModules {
    @Provides
    fun provideFilmUseCase(repository: WeatherRepository): WeatherUseCase {
        return WeatherUseCaseImpl(repository)
    }
}