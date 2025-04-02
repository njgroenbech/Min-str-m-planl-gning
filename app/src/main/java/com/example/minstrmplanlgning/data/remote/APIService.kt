package com.example.minstrmplanlgning.data.remote

import retrofit2.http.GET

interface APIService {
    @GET("strømpris")
    suspend fun getPowerPrice(): APIResponse




}