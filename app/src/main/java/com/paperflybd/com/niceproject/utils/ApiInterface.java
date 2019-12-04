package com.paperflybd.com.niceproject.utils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/users")
    Call<String> getUsers();
}
