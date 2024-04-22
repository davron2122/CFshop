package com.example.cfshopping.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel<T> extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    private T navigator;

    public T getNavigator() {
        return navigator;
    }

    public void setNavigator(T navigator) {
        this.navigator = navigator;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }

}
