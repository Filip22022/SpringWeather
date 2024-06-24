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
public class PastWeatherService {

    @Value("${apiKey}")
    private String apiKey;


    public FutureWeatherDto getPastWeather(String city, String date) throws IOException {
        Response response = callPastWeatherApi(city, date);
        ObjectMapper objectMapper = new ObjectMapper();
        if (response.body() == null) {
            throw new IOException("Response body is empty");
        }
        String json = response.body().string();
        return objectMapper.readValue(json, FutureWeatherDto.class);
    }

    private Response callPastWeatherApi(String city, String date) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(

                "http://api.weatherapi.com/v1/forecast.json"
        ).newBuilder();
        urlBuilder.addQueryParameter("key", apiKey);
        urlBuilder.addQueryParameter("q", city);
        urlBuilder.addQueryParameter("dt", date);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        return client.newCall(request).execute();
    }
}
