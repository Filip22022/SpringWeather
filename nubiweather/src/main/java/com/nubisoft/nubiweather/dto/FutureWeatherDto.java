package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.CurrentWeatherData;
import com.nubisoft.nubiweather.models.ForecastDay;
import com.nubisoft.nubiweather.models.Location;

import java.util.List;

public record FutureWeatherDto(
        Location location,
        CurrentWeatherData current,
        Forecast forecast
) {
}

record Forecast (List<ForecastDay> forecastday) {}
