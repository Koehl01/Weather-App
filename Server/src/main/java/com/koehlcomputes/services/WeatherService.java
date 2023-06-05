package com.koehlcomputes.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koehlcomputes.models.LocationInfo;
import com.koehlcomputes.models.Request;
import com.koehlcomputes.models.Response;
import com.koehlcomputes.models.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weatherStack.api.url}")
    private String apiUrl;
    @Value("${weatherStack.api.key}")
    private String key;
    public Response getWeather(Request request){

        String query = request.getQuery();
        String units = request.getUnits();
        String url = apiUrl + "/current?access_key=" + key + "&query=" + query + "&units=" + units;

        HttpEntity<String> httpEntity = new HttpEntity<>("");
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        LocationInfo locationInfo = new LocationInfo();
        WeatherInfo weatherInfo = new WeatherInfo();
        Response clientResponse = new Response();

        try{
            JsonNode locationData = objectMapper.readTree(response.getBody()).path("location");
            JsonNode weatherData = objectMapper.readTree(response.getBody()).path("current");

            locationInfo.setName(locationData.path("name").asText());
            locationInfo.setCountry(locationData.path("country").asText());
            locationInfo.setRegion(locationData.path("region").asText());
            locationInfo.setLat(locationData.path("lat").asText());
            locationInfo.setLon(locationData.path("lon").asText());
            locationInfo.setTimezoneId(locationData.path("timezone_id").asText());
            locationInfo.setLocalTime(locationData.path("country").asText());

            weatherInfo.setObservationTime(weatherData.path("observation_time").asText());
            weatherInfo.setTemperature(weatherData.path("temperature").asInt());
            weatherInfo.setWeatherCode(weatherData.path("weather_code").asInt());
            weatherInfo.setWeatherIcon(weatherData.path("weather_icons").path(0).asText());
            weatherInfo.setWeatherDescriptions(weatherData.path("weather_descriptions").path(0).asText());
            weatherInfo.setWindSpeed(weatherData.path("wind_speed").asInt());
            weatherInfo.setWindDir(weatherData.path("wind_dir").asText());
            weatherInfo.setPressure(weatherData.path("pressure").asInt());
            weatherInfo.setPrecip(weatherData.path("precip").asInt());
            weatherInfo.setHumidity(weatherData.path("humidity").asInt());
            weatherInfo.setCloudCover(weatherData.path("cloudcover").asInt());
            weatherInfo.setFeelsLike(weatherData.path("feelslike").asInt());
            weatherInfo.setUvIndex(weatherData.path("uv_index").asInt());
            weatherInfo.setVisibility(weatherData.path("visibility").asInt());
            weatherInfo.setIsDay(weatherData.path("is_day").asText());

            clientResponse.setLocationInfo(locationInfo);
            clientResponse.setWeatherInfo(weatherInfo);

        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return clientResponse;
    }
}
