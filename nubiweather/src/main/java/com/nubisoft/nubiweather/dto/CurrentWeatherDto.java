package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.Current;
import com.nubisoft.nubiweather.models.Location;

public record CurrentWeatherDto(
    Location location,
    Current current
) {}
