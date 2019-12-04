package com.paperflybd.com.niceproject.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.paperflybd.com.niceproject.R;
import com.paperflybd.com.niceproject.databinding.ActivityMainBinding;
import com.paperflybd.com.niceproject.service.model.User;
import com.paperflybd.com.niceproject.view.adapters.UsersAdapter;
import com.paperflybd.com.niceproject.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding  binding;
    private MainActivityViewModel viewModel;
    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);

        adapter = new UsersAdapter();
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(adapter);

        viewModel.getTvHeader().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvHead.setText(s);
            }
        });
        viewModel.getTvHeader().setValue("Users");




        getUserList();

    }


    private void getUserList(){
        viewModel.getUsersListObserable().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setList(users);
            }
        });
    }

}
