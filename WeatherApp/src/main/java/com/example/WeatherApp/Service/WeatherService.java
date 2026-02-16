package com.example.WeatherApp.Service;

import com.example.WeatherApp.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

    public void displayWeatherForCity(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=imperial";
        RestTemplate restTemplate = new RestTemplate();

        try {
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
            if (response != null) {
                System.out.println("Current weather for: " + city);
                System.out.println("Temperature: " + response.getMain().getTemp() + " °F");
                System.out.println("Weather Conditions: " + response.getWeather().get(0).getDescription());
            }
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}
