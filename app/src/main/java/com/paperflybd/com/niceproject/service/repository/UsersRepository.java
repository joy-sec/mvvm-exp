package com.paperflybd.com.niceproject.service.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paperflybd.com.niceproject.service.model.User;
import com.paperflybd.com.niceproject.utils.ApiInterface;
import com.paperflybd.com.niceproject.utils.NetworkClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsersRepository {


    private static UsersRepository instance;

    public static UsersRepository getInstance() {
        if (instance == null) {
            instance = new UsersRepository();
        }
        return instance;
    }

    public LiveData<List<User>> getUser(){

        final MutableLiveData<List<User>> usersData = new MutableLiveData<>();
        final List<User> list = new ArrayList<>();


        Retrofit retrofit = NetworkClient.getRetrofitClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class );
        Call<String> call = apiInterface.getUsers();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("RETR_ERR","succ");

                try {
                    JSONArray jsonArray = new JSONArray(response.body());

                    for (int i = 0;i<jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                        Gson gson = new Gson();
                        User user=gson.fromJson(String.valueOf(jsonObject),User.class);
                        list.add(user);
                    }

                    usersData.setValue(list);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("RETR_ERR","ERRROR");
            }
        });

        return  usersData;

    }

}
