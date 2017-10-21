package com.softianstech.androidtutorial.InsertRetro;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Lenovo on 8/20/2017.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")
    public void insertUser
            (
                    @Field("name") String name,
                    @Field("username") String username,
                    @Field("password") String password,
                    @Field("email") String email,
                    Callback<Response> callback
            );
}
