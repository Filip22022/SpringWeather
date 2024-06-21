package com.nubisoft.nubiweather.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CurrentWeatherData {
    private String last_updated;
    private double temp_c;
    private Condition condition;
    private double wind_kph;
    private String wind_dir;
    private double precip_mm;
    private int humidity;
    private double feelslike_c;
    private double windchill_c;
    private double heatindex_c;
    private double dewpoint_c;
    private double uv;
    private double gust_kph;
}
