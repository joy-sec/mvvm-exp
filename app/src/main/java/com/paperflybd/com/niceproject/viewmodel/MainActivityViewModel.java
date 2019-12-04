package com.paperflybd.com.niceproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.paperflybd.com.niceproject.service.model.User;
import com.paperflybd.com.niceproject.service.repository.UsersRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    MutableLiveData<String> tvHeader = new MutableLiveData<>();

    private  LiveData<List<User>> usersListObserable;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        usersListObserable = UsersRepository.getInstance().getUser();
    }


    public MutableLiveData<String> getTvHeader() {
        return tvHeader;
    }

    public LiveData<List<User>> getUsersListObserable() {
        return usersListObserable;
    }
}
