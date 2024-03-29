package com.devjockey.appmastery.Api;

import com.devjockey.appmastery.ImageResponse.ResultImage;
import com.devjockey.appmastery.LoginResponse.LoginRequest;
import com.devjockey.appmastery.LoginResponse.ResultLogin;
import com.devjockey.appmastery.MainActivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {

    //TO implement userToken
    String token = MainActivity.userToken;


    //Login Call

    @Headers({
            "Accept: application/json",
            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98"
    })
    @POST("/api/v1/apps/login")
    Call<ResultLogin> loginIn(@Body LoginRequest loginRequest);

    //Using token as default

    @Headers({
            "Accept: application/json",
            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98",
            "Authorization:token"

    })
    @GET("/api/v1/apps/catalogues?")
    Call<ResultImage> getImage(@Query("id") String id);


//
//    //test
//    @Headers({
//            "Accept: application/json",
//            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98",
//            "Authorization:token"
//
//    })
//    @GET("/api/v1/apps/catalogues?id=5d52df0a8c31223a0ea27db1")
//    Call<ResultImage> getImage();
//
//
//    @Headers({
//            "Accept: application/json",
//            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98",
//
//    })
//    @GET("/api/v1/apps/catalogues?id=5d52df458c31223a0ea27dbb")
//    Call<ResultImage> getImage2();
//
//
//    @Headers({
//            "Accept: application/json",
//            "CUSTOMERID: 5d52cd3f8c31223a0ea27d98",
//
//    })
//    @GET("/api/v1/apps/catalogues?id=5d52f12c8c31223a0ea27e29")
//    Call<ResultImage> getImage3();


}
