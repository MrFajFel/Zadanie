package com.Weather_Forecast.weather.entity;

public class Weather {
    private String language;
    private String units;
    private String country;
    private String city;
    private int days;
    private final String apiKey = "a94767f919bc44c3999221a69d3580a4";


    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getDays() {
        return days;
    }

    public String getApiKey() {
        return apiKey;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
