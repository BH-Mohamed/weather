package com.telnet.weatherapp.data.repository

import WeatherClient
import android.content.Context
import com.telnet.domain.model.Resource
import com.telnet.weatherapp.model.Town
import com.telnet.weatherapp.model.TownWeather
import com.telnet.domain.repository.IWeatherRepository
import com.telnet.weatherapp.R
import com.telnet.weatherapp.data.mappers.toTownWeather
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherClient :WeatherClient,
    @ApplicationContext var context: Context

) : IWeatherRepository {

    override suspend fun getWeatherByTown(town: Town)= flow {
        emit(Resource.Loading())
        val response = weatherClient.getWeatherByTown(town.latitude,town.longitude).single()
        if (response != null){
            emit(Resource.Success(response.toTownWeather()))
        }else{
            emit(Resource.Error(context.getString(R.string.error_ws)))
        }
    }

}