package com.wu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 总的天气实体类
 * Created by wu on 2017/1/1.
 */

public class Weather {
    public String status;

    public Basic basic;

    public Aqi aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
