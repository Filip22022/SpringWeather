# SpringWeather
A SpringBoot application exposing weather data for Hamburg and Gliwice

## Features
Two endpoints exposing data in plain text format.
- `/realtime-weather` returning current weather in both Hamburg and Gliwice
- `/forecast-weather` returning weather for the next three days for both Hamburg and Gliwice

The app makes use of [weatherapi](https://www.weatherapi.com/) for checking the weather data.

## Using the Application
To use the application on localhost:
1. Download or clone the repository
2. Download the jdk 21
3. Build and start the application using an IDE or install gradle and use command `./gradlew bootRun` or `gradlew.bat bootRun` on Windows
4. Navigate to `http://localhost:8080/forecast-weather` or `http://localhost:8080/realtime-weather` in the browser to see the weather data