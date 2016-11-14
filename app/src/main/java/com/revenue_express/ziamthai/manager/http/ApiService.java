package com.revenue_express.ziamthai.manager.http;

import com.revenue_express.ziamthai.dao.RecommendListItemDao;

import retrofit2.Call;
import retrofit2.http.POST;


/**
 * Created by ChetPC on 10/31/2016.
 */
public interface ApiService {
    @POST("index.php/shopInfo/index/1")
    Call<RecommendListItemDao>loadRecommendList();

}
