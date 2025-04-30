package com.example.minstrmplanlgning.data.remote
  
import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import retrofit2.http.*

interface MinStroemApiService {

    @GET("thirdParty/prices/{region}")
    suspend fun getPrices(
        @Header("Authorization") authHeader: String,
        @Path("region") region: String
    ): List<PriceResponseDK2>

    @GET("thirdParty/prices/location")
    suspend fun getFullPriceForLocation(
        @Header("Authorization") authHeader: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): List<FullPriceCopenhagenResponse>
  
}