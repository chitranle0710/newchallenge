package com.example.weatherforecast

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.facebook.FacebookSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }


}