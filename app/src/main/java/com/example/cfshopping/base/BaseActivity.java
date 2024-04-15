package com.example.cfshopping.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity <VB extends ViewBinding, VM extends BaseViewModel> extends AppCompatActivity implements  BaseNavigator {

    public  VB binding;
    public VM viewModel;

    protected abstract  VB inflateView(LayoutInflater inflater);
    protected abstract  VM getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=inflateView(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel=getViewModel();
    }
}
