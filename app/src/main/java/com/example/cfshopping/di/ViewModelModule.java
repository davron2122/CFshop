package com.example.cfshopping.di;


import com.example.cfshopping.remote.MainApi;
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
    MainRepository provideOnboardingRepository(SchedulerProvider schedulerProvider, MainApi mainApi, PreferenceManager preferenceManager, UserDao userDao) {
        return new MainRepository(schedulerProvider, mainApi, preferenceManager, userDao);
    }

}

