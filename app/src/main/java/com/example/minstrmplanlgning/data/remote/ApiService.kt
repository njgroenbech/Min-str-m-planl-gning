package com.example.minstrmplanlgning.data.remote
  
import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse
import retrofit2.http.*

// Nicholas

interface ApiService {

    @GET("thirdParty/prices/{region}")
    suspend fun getPrices(
        @Header("Authorization") authHeader: String,
        @Path("region") region: String
    ): List<SpotPriceResponse>

    @GET("thirdParty/prices/location")
    suspend fun getFullPriceForLocation(
        @Header("Authorization") authHeader: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): List<FullPriceResponse>
  
}