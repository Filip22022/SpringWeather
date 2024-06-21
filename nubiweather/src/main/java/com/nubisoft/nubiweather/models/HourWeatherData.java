package com.nubisoft.nubiweather.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HourWeatherData {
    private String time;
    private double temp_c;
    private int is_day;
    private Condition condition;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private double precip_mm;
    private double snow_cm;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double windchill_c;
    private double heatindex_c;
    private double dewpoint_c;
    private int will_it_rain;
    private int chance_of_rain;
    private int will_it_snow;
    private int chance_of_snow;
    private double vis_km;
    private double gust_kph;
    private double uv;
    private double short_rad;
    private double diff_rad;
}
