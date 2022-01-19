package com.example.testweather.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Weather_history")
public class WeatherHistory {

    @Id
    @Column(name = "weather_date")
    private LocalDate weatherDate;

    @Column(name = "weather_value")
    private String weatherValue;

}
