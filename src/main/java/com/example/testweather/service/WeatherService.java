package com.example.testweather.service;

import com.example.testweather.Reader.ReaderWeb;
import com.example.testweather.entities.WeatherHistory;
import com.example.testweather.repositories.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class WeatherService {

    private final ReaderWeb readerWeb;
    private final WeatherRepository weatherRepository;

    public WeatherService(ReaderWeb readerWeb, WeatherRepository weatherRepository) {
        this.readerWeb = readerWeb;
        this.weatherRepository = weatherRepository;
    }

    public String getWeather(LocalDate localDate){
        if (!weatherRepository.findFirstByWeatherDate(localDate).isPresent()){
            weatherRepository.save(new WeatherHistory(localDate, readerWeb.readWeb()));
        }
        return weatherRepository.findFirstByWeatherDate(localDate).get().getWeatherValue();
    }
}
