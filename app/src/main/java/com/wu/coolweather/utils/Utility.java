package com.wu.coolweather.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.wu.coolweather.db.City;
import com.wu.coolweather.db.County;
import com.wu.coolweather.db.Province;
import com.wu.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wu on 2016/12/30.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces=new JSONArray(response);
                for (int i = 0; i <allProvinces.length() ; i++) {
                    JSONObject proveinceObject= allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(proveinceObject.getString("name"));
                    province.setProvinceCode(proveinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String reponse,int provinceId){
        if (!TextUtils.isEmpty(reponse)){
            try {
                JSONArray allCities=new JSONArray(reponse);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */

    public static boolean handleCountyReponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handWeatherResponse(String response)
    {
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherCount=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherCount,Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
