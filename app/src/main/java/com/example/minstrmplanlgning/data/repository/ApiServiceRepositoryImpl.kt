package com.example.minstrmplanlgning.data.repository

import com.example.minstrmplanlgning.data.remote.RetrofitClient
import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse

class ApiServiceRepositoryImpl : ApiServiceRepository {
    override suspend fun getPrices(authHeader: String, region: String): List<SpotPriceResponse> {
        return RetrofitClient.apiService.getPrices(authHeader, region)
    }

    override suspend fun getFullPriceForLocation(authHeader: String, latitude: Double, longitude: Double): List<FullPriceResponse> {
        return RetrofitClient.apiService.getFullPriceForLocation(authHeader, latitude, longitude)
    }
}