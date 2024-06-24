# SpringWeather
A SpringBoot application exposing weather data for Hamburg and Gliwice

## Features
Three endpoints exposing data in plain text format.
- `/realtime-weather` returning current weather in both Hamburg and Gliwice
- `/forecast-weather` returning weather for the next three days for both Hamburg and Gliwice
- `/past-weather/{date}` where date is in yyyy-MM-dd format ( for example 2024-05-04) - returning the saved weather data from the past
  - Saves returned data in database
  - Can only return data in database or up to a week in the past from api


The app makes use of [weatherapi](https://www.weatherapi.com/) for checking the weather data.

## Using the Application
To use the application on localhost:
1. Download or clone the repository
2. Download the jdk 21 and mysql client
3. Create a mysql database `weather_history` 
   - Use the default credentials`username` and `password` or update the `application.properties` file 
4. Build and start the application using an IDE or install gradle and use command `./gradlew bootRun` or `gradlew.bat bootRun` on Windows
5. Navigate to `http://localhost:8080/forecast-weather`, `http://localhost:8080/realtime-weather` or `http://localhost:8080/past-weather/{date}` in the browser to see the weather data