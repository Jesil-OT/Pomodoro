package com.jesil.pomodoro.core.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PomodoroApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PomodoroApplication)
            modules(appModule)
        }
    }
}