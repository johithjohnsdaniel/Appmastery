package com.devjockey.appmastery;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientLogin {



    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient =new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit=new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("https://ci-api.appmastery.co").
                client(okHttpClient).
                build();

        return  retrofit;


    }

    public  static  LoginService getLoginService()
    {

        LoginService loginService =getRetrofit().create(LoginService.class);
        return loginService;


    }

}
