package com.telnet.domain.repository

import com.telnet.domain.model.Resource
import com.telnet.domain.model.Town
import com.telnet.domain.model.TownWeather
import com.telnet.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {

    suspend fun getWeatherByTown(town: Town) : Flow<Resource<List<TownWeather>>>

}