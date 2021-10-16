package com.devjockey.appmastery.ImageResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {


    @SerializedName("items")
    public List<Thumbnail> items;

    public List<Thumbnail> getItems() {
        return items;
    }

    public void setItems(List<Thumbnail> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Items{" +
                "items=" + items +
                '}';
    }

}
