package com.example.cocktailapp.injection.module

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.cocktailapp.model.repository.CocktailRepository
import com.example.cocktailapp.model.repository.ICocktailRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideCocktailRepository(): ICocktailRepository {
        return CocktailRepository(application)
    }

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return application
    }
}
