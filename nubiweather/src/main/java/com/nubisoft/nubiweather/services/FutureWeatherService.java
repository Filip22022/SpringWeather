package com.nubisoft.nubiweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubisoft.nubiweather.dto.FutureWeatherDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FutureWeatherService {

    @Value("${apiKey}")
    private String apiKey;


    public FutureWeatherDto getFutureWeather(String city) throws IOException {
        Response response = callFutureWeatherApi(city);
        ObjectMapper objectMapper = new ObjectMapper();
        if (response.body() == null) {
            throw new IOException("Response body is empty");
        }
        String json = response.body().string();
        FutureWeatherDto futureWeather = objectMapper.readValue(json, FutureWeatherDto.class);
        return futureWeather;
    }

    private Response callFutureWeatherApi(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(

                "http://api.weatherapi.com/v1/forecast.json"
        ).newBuilder();
        urlBuilder.addQueryParameter("key", apiKey);
        urlBuilder.addQueryParameter("q", city);
        urlBuilder.addQueryParameter("days", "3");
        urlBuilder.addQueryParameter("aqi", "no");
        urlBuilder.addQueryParameter("alerts", "no");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
