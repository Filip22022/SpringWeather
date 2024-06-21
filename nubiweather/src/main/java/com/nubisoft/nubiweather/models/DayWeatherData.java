package com.nubisoft.nubiweather.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DayWeatherData {
    private double maxtemp_c;
    private double mintemp_c;
    private double avgtemp_c;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalprecip_mm;
    private double totalsnow_cm;
    private double avgvis_km;
    private int avghumidity;
    private int daily_will_it_rain;
    private int daily_chance_of_rain;
    private int daily_will_it_snow;
    private int daily_chance_of_snow;
    private Condition condition;
    private double uv;
}
