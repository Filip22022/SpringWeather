package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.CurrentWeatherData;
import com.nubisoft.nubiweather.models.Location;

public record FutureWeatherDto(
        Location location,
        CurrentWeatherData current,
        ForecastDto forecast
) {
}