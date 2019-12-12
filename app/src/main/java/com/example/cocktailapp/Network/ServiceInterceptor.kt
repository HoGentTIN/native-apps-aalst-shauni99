package com.example.cocktailapp.Network

import android.content.Context
import com.example.cocktailapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor(context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

            val request = chain.request()
            val newUrl = request.url().newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()
            val newRequest = request.newBuilder()
                .url(newUrl)
                .method(request.method(), request.body())
                .build()
            return chain.proceed(newRequest)
        }
}
