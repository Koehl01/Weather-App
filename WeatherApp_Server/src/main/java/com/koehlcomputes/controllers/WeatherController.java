package com.koehlcomputes.controllers;

import com.koehlcomputes.models.Request;
import com.koehlcomputes.models.Response;
import com.koehlcomputes.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    @RequestMapping(path="/weather", method= RequestMethod.GET)
    public Response getTest(@RequestParam String query, @RequestParam String units){
        Request request = new Request(query, units);
        return weatherService.getWeather(request);
    }
}
