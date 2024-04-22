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
    private MainRepository mainRepository;

    public MutableLiveData<User> onUserLoggedIn = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginRepository loginRepository) {
        this.LoginRepository = loginRepository;
    }


    public void login() {
        User user = new User("test@gmail.com", "12341234");

        mainRepository.login(user, onUserLoggedIn, compositeDisposable, getNavigator());

    }

}
