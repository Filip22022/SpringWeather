package com.nubisoft.nubiweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nubisoft.nubiweather.dto.FutureWeatherDto;
import com.nubisoft.nubiweather.dto.PastWeatherDto;
import com.nubisoft.nubiweather.models.ForecastDay;
import com.nubisoft.nubiweather.repositories.ForecastDayRepository;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class PastWeatherService {

    @Value("${apiKey}")
    private String apiKey;
    private final ForecastDayRepository forecastDayRepository;

    public PastWeatherService(ForecastDayRepository forecastDayRepository) {
        this.forecastDayRepository = forecastDayRepository;
    }

    public ForecastDay getPastWeather(String city, String date) throws IOException {
        Optional<ForecastDay> optionalForecastDay= forecastDayRepository.findForecastDayByDate(date);
        if (optionalForecastDay.isPresent()) {
            log.info("Weather data retrieved from database");
            return optionalForecastDay.get();
        } else {
            Response response = callPastWeatherApi(city, date);
            if (response.body() == null) {
                throw new IOException("Response body is empty");
            }
            log.info("Forecastday retrieved from API");
            ForecastDay forecastDay = mapResponseToForecastDay(response);
            return forecastDayRepository.save(forecastDay);
//
//            return forecastDay;
        }
    }

    private ForecastDay mapResponseToForecastDay(Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = response.body().string();
        PastWeatherDto futureWeatherDto =  objectMapper.readValue(json, PastWeatherDto.class);
        return futureWeatherDto.forecast().forecastday().get(0);
    }

    private Response callPastWeatherApi(String city, String date) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(
                "http://api.weatherapi.com/v1/history.json"
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
