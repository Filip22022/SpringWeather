package com.nubisoft.nubiweather.controllers;

import com.nubisoft.nubiweather.dto.CurrentWeatherDto;
import com.nubisoft.nubiweather.models.BasicMessage;
import com.nubisoft.nubiweather.services.CurrentWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Slf4j
@RestController
public class WeatherController {

    private final CurrentWeatherService currentWeatherService;

    public WeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/realtime-weather")
    public BasicMessage getCurrentWeather() {
        try {
            CurrentWeatherDto currentWeather = currentWeatherService.getCurrentWeather();
            return new BasicMessage(currentWeather.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "WeatherAPI error", e);
        }
    }
}
