package com.Weather_Forecast.weather.controller;


import com.Weather_Forecast.weather.entity.Weather;
import com.Weather_Forecast.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<List<Weather>> getWeathers(@RequestParam(defaultValue = "16") int days) {



        if (days < 1 || days > 16){
            return ResponseEntity.badRequest().build();
        }

        List<Weather> weathers = weatherService.getWeathers(days);

        if (weathers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(weathers, HttpStatus.OK);
    }
}
