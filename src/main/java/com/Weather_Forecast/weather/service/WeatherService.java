package com.Weather_Forecast.weather.service;

import com.Weather_Forecast.weather.entity.Weather;
import com.Weather_Forecast.weather.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private final String API_URL =
            "https://api.weatherbit.io/v2.0/forecast/daily?days={days}&key=a94767f919bc44c3999221a69d3580a4&city={city}&country={country}&units=M";

    private final String[][] CITIES = {
            {"Jastarnia", "PL"},
            {"Bridgetown", "BB"},
            {"Fortaleza", "BR"},
            {"Pissouri", "CY"},
            {"London", "GB"}
    };

    @Autowired
    private RestTemplate restTemplate;

    // licze dla tylu dni ile mi użytkownik poda
    public List<Weather> getWeathers(int numDays) {

        List<Weather> result = new ArrayList<>();

        for (String[] c : CITIES) {
            try {
                WeatherResponse response =
                        restTemplate.getForObject(API_URL, WeatherResponse.class, numDays, c[0], c[1]);

                if (response == null || response.getData() == null || response.getData().isEmpty()) continue;

                List<Weather> days = response.getData();

                double sumTemp = 0;
                double sumWind = 0;

                for (Weather d : days) {
                    sumTemp += d.getTemp();
                    sumWind += d.getWindSpeed();
                }

                Weather w = new Weather();
                w.setCity(response.getCityName());
                w.setCountry(response.getCountryCode());
                w.setTemp(Math.round(sumTemp / days.size() * 10) / 10.0);
                w.setWindSpeed(Math.round(sumWind / days.size() * 10) / 10.0);
                result.add(w);

            } catch (Exception e) {
                System.out.println("Failed for " + c[0] + ": " + e.getMessage());
            }
        }

        return result;
    }


}


// moje inne próby getWeathers

// licze dla dzisiejszego dnia tylko
//    public List<Weather> getWeathers() {
//
//        List<Weather> result = new ArrayList<>();
//
//        for (String[] c : CITIES) {
//            try {
//                WeatherResponse response = restTemplate.getForObject(API_URL, WeatherResponse.class, c[0], c[1]);
//                if (response == null || response.getData() == null || response.getData().isEmpty()){
//                continue;
//                }
//
//                Weather w = response.getData().get(0);  // biore dzisiejszy dzień
//                w.setCity(response.getCityName());
//                w.setCountry(response.getCountryCode());
//                result.add(w);
//
//            } catch (Exception e) {
//                System.out.println("Failed " + e.getMessage()) ;
//            }
//        }
//
//        return result;
//    }

// licze dla 16 dni
//    public  List<Weather> getWeathers(){
//        List<Weather> result = new ArrayList<>();
//        for (String[] c : CITIES){
//            try {
//                WeatherResponse response = restTemplate.getForObject(API_URL, WeatherResponse.class, c[0], c[1]);
//                if (response == null || response.getData() == null || response.getData().isEmpty()) {
//                    continue;
//                }
//                List<Weather> days = response.getData();
//                double sumTemp = 0;
//                double sumWind = 0;
//
//                for (Weather d : days) {
//                    sumTemp += d.getTemp();
//                    sumWind += d.getWindSpeed();
//                }
//
//                Weather w = new Weather();
//                w.setCity(response.getCityName());
//                w.setCountry(response.getCountryCode());
//                w.setTemp(Math.round(sumTemp / days.size() * 10) / 10.0);
//                w.setWindSpeed(Math.round(sumWind / days.size() * 10) / 10.0);
//                result.add(w);
//            }catch (Exception e){
//                System.out.println("Failed" + e.getMessage());
//            }
//        }
//        return result;
//    }