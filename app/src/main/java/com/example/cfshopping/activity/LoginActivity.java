package com.example.cfshopping.activity;

import android.view.LayoutInflater;

import com.example.cfshopping.base.BaseActivity;
import com.example.cfshopping.base.BaseNavigator;
import com.example.cfshopping.base.BaseViewModel;
import com.example.cfshopping.databinding.ActivityLoginBinding;
import com.example.cfshopping.navigator.LoginNavigator;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements LoginNavigator {
    @Override
    protected ActivityLoginBinding inflateView(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }
}
