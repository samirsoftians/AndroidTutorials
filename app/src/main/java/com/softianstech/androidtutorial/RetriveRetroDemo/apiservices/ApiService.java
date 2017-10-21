package com.softianstech.androidtutorial.RetriveRetroDemo.apiservices;


import com.softianstech.androidtutorial.RetriveRetroDemo.models.ListFoodModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by putuguna on 1/24/2017.
 */

public interface ApiService {
    @GET("/RetrofitExample/DisplayJsonFood.php")//food/DisplayJsonFood.php
    Call<ListFoodModel> getAllDataFood();
}
