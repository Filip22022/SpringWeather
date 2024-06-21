package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.CurrentWeatherData;
import com.nubisoft.nubiweather.models.Location;

public record CurrentWeatherDto(
    Location location,
    CurrentWeatherData current
) {}
