package com.example.cocktailapp

import android.app.Application
import com.example.cocktailapp.Injection.component.AppComponent
import com.example.cocktailapp.Injection.component.DaggerAppComponent
import com.example.cocktailapp.Injection.module.DatabaseModule
import com.example.cocktailapp.Injection.module.NetworkModule

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
