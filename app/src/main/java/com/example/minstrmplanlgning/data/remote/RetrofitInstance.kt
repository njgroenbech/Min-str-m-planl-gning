package com.example.minstrmplanlgning.data.remote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("placeholder til vores api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}