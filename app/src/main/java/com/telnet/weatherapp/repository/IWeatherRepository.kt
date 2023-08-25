package com.telnet.domain.repository

import com.telnet.domain.model.Resource
import com.telnet.weatherapp.model.Town
import com.telnet.weatherapp.model.TownWeather
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {

    suspend fun getWeatherByTown(town: Town) : Flow<Resource<TownWeather>>

}