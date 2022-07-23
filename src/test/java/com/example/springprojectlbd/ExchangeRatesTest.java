package com.example.springprojectlbd;

import com.example.springprojectlbd.dto.ExchangeRateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExchangeRatesTest {
    public RestTemplate restTemplate = new RestTemplate();
    public static final String baseUrl = "http://api.nbp.pl/api/";

    @Test
    public void getExchangeRatesPrevDay() {

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        if (yesterday.getDayOfWeek() == DayOfWeek.SATURDAY)
            yesterday = yesterday.minusDays(1);
        if (yesterday.getDayOfWeek() == DayOfWeek.SUNDAY)
            yesterday = yesterday.minusDays(2);
        String yesterdayStr = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        ResponseEntity<ExchangeRateDto[]> rest= restTemplate.getForEntity(baseUrl+"exchangerates/tables/a/"+yesterdayStr,ExchangeRateDto[].class);
        for (ExchangeRateDto exchangeRateDto : rest.getBody())
            System.out.println(exchangeRateDto.getFormatForTable());
    }



    @Test
    public void get10Rate(){
        ResponseEntity<ExchangeRateDto> responseEntity = restTemplate.getForEntity(baseUrl+"exchangerates/rates/a/usd/last/10/?format=json",ExchangeRateDto.class);
            System.out.println(responseEntity.getBody().getFormatForSingleValue());
    }
    }

