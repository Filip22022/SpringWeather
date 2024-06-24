package com.nubisoft.nubiweather.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class ForecastDay {

    @Id
    @GeneratedValue
    public Long id;

    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_weather_data_id", referencedColumnName = "id")
    private DayWeatherData day;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hour_weather_data_id", referencedColumnName = "id")
    private List<HourWeatherData> hour;
}
