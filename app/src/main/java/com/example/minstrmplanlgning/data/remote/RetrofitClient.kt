package com.example.minstrmplanlgning.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.minstroem.app/thirdParty"

    private const val apiKey = API_KEY

    val apiService: MinStroemApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MinStroemApiService::class.java)
}