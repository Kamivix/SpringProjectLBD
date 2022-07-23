package com.example.springprojectlbd.dto;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateDto {

    String table;
    String no;
    String effectiveData;

    String code;

    String currency;
    List<Rate> rates = new ArrayList<>();

    public String getTable() {
        return table;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveData() {
        return effectiveData;
    }

    public void setEffectiveData(String effectiveData) {
        this.effectiveData = effectiveData;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public ExchangeRateDto() {
    }

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


class Rate{
    String currency;
    String code;
    Double mid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Rate() {
    }
}
