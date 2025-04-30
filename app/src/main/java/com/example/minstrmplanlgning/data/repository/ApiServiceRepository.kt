package com.example.minstrmplanlgning.data.repository

import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse

interface ApiServiceRepository {
    suspend fun getPrices(authHeader: String, region: String): List<SpotPriceResponse>
    suspend fun getFullPriceForLocation(authHeader: String, latitude: Double, longitude: Double):
            List<FullPriceResponse>
}