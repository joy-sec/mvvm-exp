package com.paperflybd.com.niceproject.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.paperflybd.com.niceproject.R;
import com.paperflybd.com.niceproject.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_login);

    }
}
