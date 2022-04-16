package com.rickAndMorty

import android.app.Application
import android.content.Context
import com.rickAndMorty.di.AppComponent
import com.rickAndMorty.di.AppModule
import com.rickAndMorty.di.DaggerAppComponent

class RMApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is RMApplication -> appComponent
        else -> this.applicationContext.appComponent
    }