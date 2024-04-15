package com.example.cfshopping.activity;

import android.view.LayoutInflater;

import com.example.cfshopping.base.BaseActivity;

import com.example.cfshopping.databinding.ActivityLoginBinding;
import com.example.cfshopping.navigator.LoginNavigator;
import com.example.cfshopping.vm.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {
    @Override
    protected ActivityLoginBinding inflateView(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected LoginViewModel getViewModel() {
        return null;
    }
}
