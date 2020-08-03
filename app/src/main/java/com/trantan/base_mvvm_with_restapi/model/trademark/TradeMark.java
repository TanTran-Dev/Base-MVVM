package com.trantan.base_mvvm_with_restapi.model.trademark;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public
class TradeMark {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("name")
    @Expose
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
