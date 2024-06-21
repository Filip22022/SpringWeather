package com.nubisoft.nubiweather.controllers;

import com.nubisoft.nubiweather.dto.CurrentWeatherDto;
import com.nubisoft.nubiweather.dto.FutureWeatherDto;
import com.nubisoft.nubiweather.models.BasicMessage;
import com.nubisoft.nubiweather.services.CurrentWeatherService;
import com.nubisoft.nubiweather.services.FutureWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class WeatherController {

    private final CurrentWeatherService currentWeatherService;
    private final FutureWeatherService futureWeatherService;

    @Autowired
    public WeatherController(CurrentWeatherService currentWeatherService, FutureWeatherService futureWeatherService) {
        this.currentWeatherService = currentWeatherService;
        this.futureWeatherService = futureWeatherService;
    }

    @GetMapping("/realtime-weather")
    public List<CurrentWeatherDto> getCurrentWeather() {
        try {
            CurrentWeatherDto currentWeatherGliwice = currentWeatherService.getCurrentWeather("Gliwice");
            CurrentWeatherDto currentWeatherHamburg = currentWeatherService.getCurrentWeather("Hamburg");
            return List.of(currentWeatherHamburg, currentWeatherGliwice);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "WeatherAPI error", e);
        }
    }

    @GetMapping("/forecast-weather")
    public List<FutureWeatherDto> getFutureWeather() {
        try {
            FutureWeatherDto futureWeatherGliwice = futureWeatherService.getFutureWeather("Gliwice");
            FutureWeatherDto futureWeatherHamburg = futureWeatherService.getFutureWeather("Hamburg");
            return List.of(futureWeatherHamburg, futureWeatherGliwice);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "WeatherAPI error", e);
        }
    }
}
