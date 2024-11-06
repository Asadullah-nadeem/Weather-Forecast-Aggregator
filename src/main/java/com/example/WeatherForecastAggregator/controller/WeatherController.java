package com.example.WeatherForecastAggregator.controller;

import com.example.WeatherForecastAggregator.model.WeatherResponse;
import com.example.WeatherForecastAggregator.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public Mono<WeatherResponse> getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}