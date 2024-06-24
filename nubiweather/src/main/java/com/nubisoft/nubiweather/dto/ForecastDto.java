package com.nubisoft.nubiweather.dto;

import com.nubisoft.nubiweather.models.ForecastDay;

import java.util.List;

record ForecastDto(List<ForecastDay> forecastday) {}