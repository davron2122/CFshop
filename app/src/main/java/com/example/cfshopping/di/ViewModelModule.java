package com.example.cfshopping.di;


import com.example.cfshopping.db.UserDao;
import com.example.cfshopping.remote.MainApi;
import com.example.cfshopping.repository.LoginRepository;
import com.example.cfshopping.rx.SchedulerProvider;
import com.example.cfshopping.utils.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
public class ViewModelModule {


    @Provides
    @ViewModelScoped
    LoginRepository provideOnboardingRepository(SchedulerProvider schedulerProvider, MainApi mainApi, PreferenceManager preferenceManager, UserDao userDao) {
        return new LoginRepository(schedulerProvider, mainApi, preferenceManager, userDao);
    }

}

