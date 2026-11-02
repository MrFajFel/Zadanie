package com.Weather_Forecast.weather.response;

import com.Weather_Forecast.weather.entity.Weather;

import java.util.List;

public class WeatherResponse {

    private List<Weather> data;

    public List<Weather> getData() {
        return data;
    }

    public void setData(List<Weather> data) {
        this.data = data;
    }
}