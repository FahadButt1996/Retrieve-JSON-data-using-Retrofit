package com.example.mfahad.jsondata;

/**
 * Created by M.FAHAD on 8/15/2017.
 */

public class ApiUtils {
    public static String url = "http://jsonplaceholder.typicode.com";
    public ApiUtils(){}
    public static ApiInterface getApiInterface(){
        return RetrofitClient.getRetrofit(url).create(ApiInterface.class);
    }
}
