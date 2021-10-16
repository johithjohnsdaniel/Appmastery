package com.devjockey.appmastery.ImageResponse;

import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("medium")
    String medium;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "Model{" +
                "medium='" + medium + '\'' +
                '}';
    }
}
