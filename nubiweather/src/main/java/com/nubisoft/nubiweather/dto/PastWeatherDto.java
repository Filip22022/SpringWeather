package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.Location;

public record PastWeatherDto(
        Location location,
        ForecastDto forecast
) {
}