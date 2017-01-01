package com.wu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wu on 2017/1/1.
 */

public class Now {
    @SerializedName("tem")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
