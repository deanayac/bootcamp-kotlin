package com.bootcamp.kotlin

import android.app.Application
import com.bootcamp.kotlin.util.AndroidHelper
import com.bootcamp.kotlin.util.CrashlyticsTree
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class ConfigurationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimberWithFirebaseCrashlytics()
        AndroidHelper.init(applicationContext)
        initDI()
    }

    private fun initTimberWithFirebaseCrashlytics() {
        if (BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false)
            Timber.plant(Timber.DebugTree())
        } else {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
            Timber.plant(CrashlyticsTree())
        }
    }
}