package com.example.minstrmplanlgning.data.useCase

import com.example.minstrmplanlgning.BuildConfig
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse
import com.example.minstrmplanlgning.data.repository.ApiServiceRepository

class GetSpotPricesUseCase(private val priceRepository: ApiServiceRepository) {
    suspend operator fun invoke(region: String): Result<List<SpotPriceResponse>> {
        return try {
            val bearer = "Bearer ${BuildConfig.BEARER_TOKEN}"
            val prices = priceRepository.getPrices(bearer, region)
            Result.success(prices)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}