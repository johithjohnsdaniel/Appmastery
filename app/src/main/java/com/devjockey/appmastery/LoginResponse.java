package com.devjockey.appmastery;

public class LoginResponse {

    public  String name;
    public  String user_token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "name='" + name + '\'' +
                ", user_token='" + user_token + '\'' +
                '}';
    }
}
