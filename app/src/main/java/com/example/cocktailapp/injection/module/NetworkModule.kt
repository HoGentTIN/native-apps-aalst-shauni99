package com.example.cocktailapp.injection.module

import android.content.Context
import android.net.ConnectivityManager
import com.example.cocktailapp.BuildConfig
import com.example.cocktailapp.Network.CocktailService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule(private val context: Context) {

    @Provides
    internal fun provideCocktailService(retrofit: Retrofit): CocktailService {
        return retrofit.create(CocktailService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofitInterface(): Retrofit {
        val client = OkHttpClient.Builder()
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}
