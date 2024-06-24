package com.nubisoft.nubiweather.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "weather_condition")
public class Condition {

    @Id
    @GeneratedValue
    public Long id;
    private String text;
}
