package com.example.mfahad.jsondata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
//       this below line give the retrofit objwct
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

            apiInterface = retrofit.create(ApiInterface.class);
            Call<List<Data>> call = apiInterface.getData();
            call.enqueue(new Callback<List<Data>>() {
                @Override
                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                    Toast.makeText(MainActivity.this, "" + response.body().get(0).getId() +
                            " " + response.body().get(0).getEmail() +
                            " " +response.body().get(0).getName(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
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
