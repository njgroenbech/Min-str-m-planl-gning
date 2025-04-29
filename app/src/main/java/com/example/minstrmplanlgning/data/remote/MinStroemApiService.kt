package com.example.minstrmplanlgning.data.remote

import com.example.minstrmplanlgning.data.remote.dto.AuthResponse
import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import retrofit2.http.*

interface MinStroemApiService {
    @POST("auth/token")
    suspend fun getAccessToken(@Body request: AuthRequest): AuthResponse

    @GET("prices/{region}")
    suspend fun getPrices(
        @Header("Authorization") authHeader: String,
        @Path("region") region: String
    ): List<PriceResponseDK2>
}