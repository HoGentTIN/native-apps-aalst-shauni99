package com.example.cocktailapp.injection.module

import android.app.Application
import android.content.Context
import com.example.cocktailapp.Model.Repository.CocktailRepository
import com.example.cocktailapp.Model.Repository.ICocktailRepository
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
