package com.nubisoft.nubiweather.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class HourWeatherData {

    @Id
    @GeneratedValue
    public Long id;
    private String time;
    private double temp_c;
    private int is_day;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
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
}
