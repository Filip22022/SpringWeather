package com.nubisoft.nubiweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubisoft.nubiweather.dto.CurrentWeatherDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrentWeatherService {

    @Value("${apiKey}")
    private String apiKey;


    public CurrentWeatherDto getCurrentWeather(String city) throws IOException {
        Response response = callCurrentWeatherApi(city);
        ObjectMapper objectMapper = new ObjectMapper();
        if (response.body() == null) {
            throw new IOException("Response body is empty");
        }
        String json = response.body().string();
        return objectMapper.readValue(json, CurrentWeatherDto.class);
    }

    private Response callCurrentWeatherApi(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(
                "http://api.weatherapi.com/v1/current.json"
        ).newBuilder();
        urlBuilder.addQueryParameter("key", apiKey);
        urlBuilder.addQueryParameter("q", city);
        urlBuilder.addQueryParameter("aqi", "no");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
