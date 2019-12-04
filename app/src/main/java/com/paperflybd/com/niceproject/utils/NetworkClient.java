package com.paperflybd.com.niceproject.utils;

import retrofit2.Retrofit;

public class NetworkClient {

    private static Retrofit retrofit;

    private static String base_url = "https://api.github.com/";


    public static Retrofit getRetrofitClient(){

        if (retrofit==null){
            retrofit  = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(new ToStringConverterFactory())
                    .build();
        }

        return retrofit;

    }

}
