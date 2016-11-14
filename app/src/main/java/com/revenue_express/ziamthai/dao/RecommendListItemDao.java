package com.revenue_express.ziamthai.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ChetPC on 10/31/2016.
 */
public class RecommendListItemDao implements Parcelable {

    @SerializedName("result") private Boolean result;
    @SerializedName("data") private List<RecommendItemDao> data;

    protected RecommendListItemDao(Parcel in) {
        data = in.createTypedArrayList(RecommendItemDao.CREATOR);
    }

    public static final Creator<RecommendListItemDao> CREATOR = new Creator<RecommendListItemDao>() {
        @Override
        public RecommendListItemDao createFromParcel(Parcel in) {
            return new RecommendListItemDao(in);
        }

        @Override
        public RecommendListItemDao[] newArray(int size) {
            return new RecommendListItemDao[size];
        }
    };

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<RecommendItemDao> getData() {
        return data;
    }

    public void setData(List<RecommendItemDao> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
    }
}
