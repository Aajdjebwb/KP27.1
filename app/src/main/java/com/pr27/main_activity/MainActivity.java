package com.pr27.main_activity;

import static org.koin.java.KoinJavaComponent.get;

import android.os.Bundle;

import com.pr27.basic.mvvm.BaseActivity;
import com.pr27.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBookViewModel viewModel = get(MainActivityBookViewModel.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

    }

    @Override
    public void onCloseScope() {

    }
}

