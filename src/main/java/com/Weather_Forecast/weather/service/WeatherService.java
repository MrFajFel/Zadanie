package com.Weather_Forecast.weather.service;

import com.Weather_Forecast.weather.entity.Weather;
import com.Weather_Forecast.weather.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WeatherService {

    private final String API_URL =
            "https://api.weatherbit.io/v2.0/forecast/daily?days=16&key=a94767f919bc44c3999221a69d3580a4&city=Raleigh,NC&country=US&units=M";

    @Autowired
    private RestTemplate restTemplate;

    public List<Weather> getWeathers() {

        WeatherResponse response =
                restTemplate.getForObject(API_URL, WeatherResponse.class);

        return response != null
                ? response.getData()
                : Collections.emptyList();
    }
}
