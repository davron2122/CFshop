package com.example.cfshopping.repository;



import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.cfshopping.base.BaseRepository;
import com.example.cfshopping.db.UserDao;
import com.example.cfshopping.model.User;
import com.example.cfshopping.navigator.LoginNavigator;
import com.example.cfshopping.remote.MainApi;
import com.example.cfshopping.rx.SchedulerProvider;
import com.example.cfshopping.utils.PreferenceManager;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class LoginRepository extends BaseRepository {
    private MainApi mainApi;
    private UserDao userDao;
    private PreferenceManager preferenceManager;

    @Inject
    public LoginRepository(SchedulerProvider schedulerProvider, MainApi mainApi, PreferenceManager preferenceManager, UserDao userDao) {
        super(schedulerProvider);
        this.mainApi = mainApi;
        this.userDao = userDao;
        this.preferenceManager = preferenceManager;
    }

    public void login(User user, MutableLiveData<User> onLoggedIn, CompositeDisposable compositeDisposable, LoginNavigator navigator) {
        Single<User> call = mainApi.login(user);
        navigator.showLoadingBar();
        call.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe(new SingleObserver<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull User user) {
                onLoggedIn.setValue(user);

                userDao.insertAll(user).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("DB", "User is inserted");
                        navigator.hideLoadingBar();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (navigator != null)
                            navigator.hideLoadingBar();
                    }
                });

            }

            @Override
            public void onError(@NonNull Throwable e) {
                navigator.hideLoadingBar();
            }
        });

    }
}
