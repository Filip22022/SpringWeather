package com.nubisoft.nubiweather.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ForecastDay {
    private String date;
    private DayWeatherData day;
    private List<HourWeatherData> hour;
}
