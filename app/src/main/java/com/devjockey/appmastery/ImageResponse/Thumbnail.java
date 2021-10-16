package com.devjockey.appmastery.ImageResponse;

import com.google.gson.annotations.SerializedName;

public class Thumbnail {

    @SerializedName("name")
    String name;
    @SerializedName("thumbnail")
    public Model thumbnail;

    public Model getThumbnail() {
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(Model thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "name='" + name + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
