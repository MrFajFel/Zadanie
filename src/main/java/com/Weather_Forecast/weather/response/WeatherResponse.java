package com.Weather_Forecast.weather.response;

import com.Weather_Forecast.weather.entity.Weather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("country_code")
    private String countryCode;

    private List<Weather> data;

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Weather> getData() {
        return data;
    }
    public void setData(List<Weather> data) {
        this.data = data;
    }
}