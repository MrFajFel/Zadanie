package com.Weather_Forecast.weather.controller;


import com.Weather_Forecast.weather.entity.Weather;
import com.Weather_Forecast.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<List<Weather>> getWeathers(){
        List<Weather> weathers = weatherService.getWeathers();

        if (weathers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(weathers,HttpStatus.OK);
    }
}
