package com.example.minstrmplanlgning.data.useCase

import com.example.minstrmplanlgning.BuildConfig
import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.repository.ApiServiceRepository

// Nicholas

class GetFullPricesUseCase(private val priceRepository: ApiServiceRepository) {
    suspend operator fun invoke(latitude: Double, longitude: Double): Result<List<FullPriceResponse>> {
        return try {
            val bearer = "Bearer ${BuildConfig.BEARER_TOKEN}"
            val fullPrices = priceRepository.getFullPriceForLocation(bearer, latitude, longitude)
            Result.success(fullPrices)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}