package com.devjockey.appmastery;

import com.google.gson.annotations.SerializedName;

public class ResultImage {

    @SerializedName("_embedded")
    public Items _embedded;

    public ResultImage(Items _embedded) {
        this._embedded = _embedded;
    }

    public Items get_embedded() {
        return _embedded;
    }

    public void set_embedded(Items _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "Result{" +
                "_embedded=" + _embedded +
                '}';
    }

}
