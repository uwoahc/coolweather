package com.wu.coolweather.gson;

/**
 * Created by wu on 2017/1/1.
 */

public class Aqi {
    public AQICity city;

    public class AQICity {
        public String api;
        public String pm25;
    }
}
