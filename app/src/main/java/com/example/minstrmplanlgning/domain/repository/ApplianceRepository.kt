package com.example.minstrmplanlgning.domain.repository

import com.example.minstrmplanlgning.domain.model.ApplianceData

interface ApplianceRepository {
    suspend fun addAppliance(appliance: ApplianceData): Result<Unit>
}
