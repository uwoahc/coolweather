package com.wu.coolweather.gson;

/**
 * Created by wu on 2017/1/1.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
