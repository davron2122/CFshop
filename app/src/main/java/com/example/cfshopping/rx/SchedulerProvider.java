package com.example.cfshopping.rx;

import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerProvider {

    Scheduler io(); // background

    Scheduler ui(); // foreground

}
