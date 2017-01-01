package com.wu.coolweather.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wu on 2016/12/30.
 * 网络请求封装的工具类
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }
}
