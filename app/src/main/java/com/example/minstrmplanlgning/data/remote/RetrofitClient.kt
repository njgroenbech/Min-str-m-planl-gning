package com.example.minstrmplanlgning.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Nicholas

object RetrofitClient {
    private const val BASE_URL = "https://api.minstroem.app/"

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}