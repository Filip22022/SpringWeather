package com.nubisoft.nubiweather.repositories;

import com.nubisoft.nubiweather.models.ForecastDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForecastDayRepository extends JpaRepository<ForecastDay, Long> {

    Optional<ForecastDay> findForecastDayByDate(String date);
}
