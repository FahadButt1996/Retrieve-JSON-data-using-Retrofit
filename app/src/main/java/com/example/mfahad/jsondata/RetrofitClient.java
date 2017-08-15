package com.example.mfahad.jsondata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M.FAHAD on 8/15/2017.
 */

public class RetrofitClient {
    protected static Retrofit retrofit;

    protected static Retrofit getRetrofit(String Url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
