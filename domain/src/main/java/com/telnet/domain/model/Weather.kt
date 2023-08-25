package com.telnet.domain.model

data class TownWeather(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val current : Weather,
    val hourly: List<Weather>,
    val daily: List<Weather>,
)

data class Weather(
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val wind_gust: Double,
    val description : String,
    val icon : String
)