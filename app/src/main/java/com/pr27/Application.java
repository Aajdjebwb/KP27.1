package com.pr27;

import static com.pr27.basic.koin.JavaKoin.startKoinApplication;

import androidx.lifecycle.LifecycleObserver;

public class Application extends android.app.Application implements LifecycleObserver {

    public static final String TAG = "StatisticApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        startKoinApplication(this);
    }
}
