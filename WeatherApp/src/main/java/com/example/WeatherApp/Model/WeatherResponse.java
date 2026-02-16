package com.example.WeatherApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private MainData main;
    private List<WeatherDescription> weather;

    public MainData getMain() {
        return main;
    }
    public void setMain(MainData main) {
        this.main = main;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }
    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }
}
