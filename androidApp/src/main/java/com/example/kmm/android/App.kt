package com.example.kmm.android

import android.app.Application
import com.example.kmm.android.di.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                KoinModule.get()
            )
        }
    }
}