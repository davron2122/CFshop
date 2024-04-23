package com.example.cfshopping.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cfshopping.base.BaseActivity;

import com.example.cfshopping.databinding.ActivityLoginBinding;
import com.example.cfshopping.model.User;
import com.example.cfshopping.navigator.LoginNavigator;
import com.example.cfshopping.vm.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {
    @Override
    protected ActivityLoginBinding inflateView(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected LoginViewModel getViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewModel.login();
            }
        });

        viewModel.onUserLoggedIn.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void hideLoadingBar() {

    }
}
