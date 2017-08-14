package com.example.mfahad.jsondata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by M.FAHAD on 8/14/2017.
 */

public interface ApiInterface {
    @GET("/comments")
    Call<List<Data>> getData();
}
