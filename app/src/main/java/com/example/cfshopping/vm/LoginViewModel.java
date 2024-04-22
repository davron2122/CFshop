package com.example.cfshopping.vm;

import androidx.lifecycle.MutableLiveData;

import com.example.cfshopping.base.BaseViewModel;
import com.example.cfshopping.model.User;
import com.example.cfshopping.navigator.LoginNavigator;
import com.example.cfshopping.repository.LoginRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    private LoginRepository loginRepository;

    public MutableLiveData<User> onUserLoggedIn = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public void login() {
        User user = new User("test@gmail.com", "12341234");

        loginRepository.login(user, onUserLoggedIn, compositeDisposable, getNavigator());

    }

}
