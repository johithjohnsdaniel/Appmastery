package com.devjockey.appmastery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {

    //Login Call

    @Headers({
            "Accept: application/json",
            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98"
    })
    @POST("/api/v1/apps/login")
    Call<ResultLogin> loginIn(@Body LoginRequest loginRequest);

    //Image Request
                                           //TEST


//    @Headers({
//            "Accept: application/json",
//            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98"
//    })
//    @POST("/api/v1/apps/login/{id}")
//    Call<List<ResultImage>> getImage(@Path("Id") int id);





}
