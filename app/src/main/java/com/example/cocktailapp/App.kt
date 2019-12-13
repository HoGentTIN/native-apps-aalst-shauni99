package com.example.cocktailapp

import android.app.Application
import com.example.cocktailapp.injection.component.AppComponent
import com.example.cocktailapp.injection.component.DaggerAppComponent
import com.example.cocktailapp.injection.module.DatabaseModule
import com.example.cocktailapp.injection.module.NetworkModule

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .databaseModule(DatabaseModule(this))
            .networkModule(NetworkModule(this))
            .build()
    }
}
