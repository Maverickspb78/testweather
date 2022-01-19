package com.example.testweather.repositories;

import com.example.testweather.entities.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherHistory, Date> {
   Optional<WeatherHistory>findFirstByWeatherDate(LocalDate LocalDate);

}
