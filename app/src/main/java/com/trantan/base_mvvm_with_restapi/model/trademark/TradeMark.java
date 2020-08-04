package com.trantan.base_mvvm_with_restapi.model.trademark;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.trantan.base_mvvm_with_restapi.BR;

import de.hdodenhof.circleimageview.CircleImageView;

public
class TradeMark extends BaseObservable {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("name")
    @Expose
    private String name;

    public TradeMark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(CircleImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }
}
