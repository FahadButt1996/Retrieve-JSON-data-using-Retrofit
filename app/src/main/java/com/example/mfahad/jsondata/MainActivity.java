package com.example.mfahad.jsondata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            apiInterface = ApiUtils.getApiInterface();
            Call<List<Data>> call = apiInterface.getData();
            call.enqueue(new Callback<List<Data>>() {
                @Override
                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                    recyclerView =(RecyclerView) findViewById(R.id.RecyclerView);
                    layoutManager = new LinearLayoutManager(getBaseContext());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new Adapter((ArrayList<Data>) response.body() , getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
                @Override
                public void onFailure(Call<List<Data>> call, Throwable t) {

                }
            });
        }catch (Exception e ){
            e.getMessage();
        }
    }
}
