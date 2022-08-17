package com.example.springprojectlbd.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class ExchangeRateDto {

    String table;
    String no;
    String effectiveData;

    String code;

    String currency;
    List<Rate> rates = new ArrayList<>();

    public String getFormatForTable() {
        StringBuilder  stringBuilder = new StringBuilder();

        for (Rate rate : getRates())
            stringBuilder.append("\t").append(rate.getCurrency()).append("\t|\t").append(rate.getMid()).append("\n").append(getTable()).append("\n");

        return stringBuilder.toString();
    }

    public String getFormatForSingleValue(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTable()).append("\t|\t").append(getCurrency()).append("\t|\t").append(getCode()).append("\n");
        for(Rate rate: getRates()){
            stringBuilder.append(rate.getMid()).append("\n");
        }
        return stringBuilder.toString();
    }



}

@Getter
@Setter
@NoArgsConstructor
class Rate{
    String currency;
    String code;
    Double mid;


}
