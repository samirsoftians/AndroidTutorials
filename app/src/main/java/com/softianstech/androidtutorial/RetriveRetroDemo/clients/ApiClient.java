package com.softianstech.androidtutorial.RetriveRetroDemo.clients;


import com.softianstech.androidtutorial.RetriveRetroDemo.utils.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by putuguna on 1/24/2017.
 */

public class ApiClient {

    public static final String URL      = "http://samir1010.000webhostapp.com/";
    public static Retrofit RETROFIT     = null;

    public static Retrofit getClient(){
        if(RETROFIT==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }
}
