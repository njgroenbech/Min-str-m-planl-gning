package com.example.minstrmplanlgning.data.remote
  
import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import retrofit2.http.*

interface MinStroemApiService {

    @GET("prices/{region}")
    suspend fun getPrices(
        @Header("Authorization") authHeader: String,
        @Path("region") region: String
    ): List<PriceResponseDK2>
}