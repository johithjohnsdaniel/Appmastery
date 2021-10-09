package com.devjockey.appmastery;

public class ResultLogin {

    public LoginResponse response;

    public LoginResponse getResponse() {
        return response;
    }

    public void setResponse(LoginResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResultLogin{" +
                "response=" + response +
                '}';
    }
}
