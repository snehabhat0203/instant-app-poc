package com.example.instantapppoc.service

import com.example.instantapppoc.service.RemoteService.Companion.ENDPOINT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteServiceProvider {
    fun getService(): RemoteService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder().baseUrl(ENDPOINT)
            .client(
                OkHttpClient.Builder().addInterceptor(interceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RemoteService::class.java)
    }
}