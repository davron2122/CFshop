package com.example.cfshopping.base;

import com.example.cfshopping.rx.SchedulerProvider;

public  abstract class BaseRepository {
    public SchedulerProvider schedulerProvider;

    public BaseRepository(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }
}
