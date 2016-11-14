package com.revenue_express.ziamthai.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ChetPC on 10/31/2016.
 */
public class RecommendItemDao implements Parcelable {

    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("detail") private String detail;
    @SerializedName("address") private String address;
    @SerializedName("country") private String country;
    @SerializedName("state") private String state;
    @SerializedName("city") private String city;
    @SerializedName("map") private String map;
    @SerializedName("image") private String image;
    @SerializedName("phone") private String phone;

    protected RecommendItemDao(Parcel in) {
        id = in.readString();
        name = in.readString();
        detail = in.readString();
        address = in.readString();
        country = in.readString();
        state = in.readString();
        city = in.readString();
        map = in.readString();
        image = in.readString();
        phone = in.readString();
    }

    public static final Creator<RecommendItemDao> CREATOR = new Creator<RecommendItemDao>() {
        @Override
        public RecommendItemDao createFromParcel(Parcel in) {
            return new RecommendItemDao(in);
        }

        @Override
        public RecommendItemDao[] newArray(int size) {
            return new RecommendItemDao[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(detail);
        parcel.writeString(address);
        parcel.writeString(country);
        parcel.writeString(state);
        parcel.writeString(city);
        parcel.writeString(map);
        parcel.writeString(image);
        parcel.writeString(phone);
    }
}
