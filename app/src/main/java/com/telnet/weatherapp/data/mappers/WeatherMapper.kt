package com.telnet.weatherapp.data.mappers

import com.telnet.data.dto.CurrentWeather
import com.telnet.data.dto.DailyWeather
import com.telnet.data.dto.HourlyWeather
import com.telnet.data.dto.WeatherResponse
import com.telnet.weatherapp.model.TownWeather
import com.telnet.weatherapp.model.Weather

fun WeatherResponse.toTownWeather() = TownWeather(
    latitude = lat,
    longitude = lon,
    timezone = timezone,
    current = current.toWeather(),
    hourly = hourly.map { it.toWeather() },
    daily = daily.map { it.toWeather() }

)


fun CurrentWeather.toWeather() = Weather(
    temp = temp,
    feels_like = feels_like,
    pressure = pressure,
    humidity = humidity,
    dew_point = dew_point,
    clouds = clouds,
    visibility = visibility,
    wind_speed = wind_speed,
    wind_deg = wind_deg,
    description = if (weather.isEmpty()) "" else weather.first().description,
    icon = if (weather.isEmpty()) "" else weather.first().icon,
    pop = 0.0,
    uvi= uvi,
    rain = 0.0
)

fun HourlyWeather.toWeather() = Weather(
    temp = temp,
    feels_like = feels_like,
    pressure = pressure,
    humidity = humidity,
    dew_point = dew_point,
    clouds = clouds,
    visibility = visibility,
    wind_speed = wind_speed,
    wind_deg = wind_deg,
    description = if (weather.isEmpty()) "" else weather.first().description,
    icon = if (weather.isEmpty()) "" else weather.first().icon,
    pop = pop,
    uvi= uvi,
    rain = 0.0
)

fun DailyWeather.toWeather() = Weather(
    temp = 0.0,
    feels_like = feels_like.day,
    pressure = pressure,
    humidity = humidity,
    dew_point = dew_point,
    clouds = clouds,
    wind_speed = wind_speed,
    wind_deg = wind_deg,
    description = if (weather.isEmpty()) "" else weather.first().description,
    icon = if (weather.isEmpty()) "" else weather.first().icon,
    pop = pop,
    uvi= uvi,
    rain = rain,
    visibility = 0
)