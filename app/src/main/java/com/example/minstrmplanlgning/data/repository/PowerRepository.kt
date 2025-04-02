package com.example.minstrmplanlgning.data.repository
import com.example.minstrmplanlgning.data.remote.RetrofitInstance

class PowerRepository {

    // Henter strømpris fra API (gennem Retrofit)
    suspend fun getPowerPrice() = RetrofitInstance.api.getPowerPrice()
}