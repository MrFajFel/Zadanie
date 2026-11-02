package com.Weather_Forecast.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private String country;
    private String city;
    private double temp;

    @JsonProperty("wind_spd")
    private double windSpeed;

    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public double getTemp() {
        return temp;
    }
    public double getWindSpeed() {
        return windSpeed;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}