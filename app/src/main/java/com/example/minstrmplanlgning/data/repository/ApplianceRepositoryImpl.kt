package com.example.minstrmplanlgning.data.repository

import com.example.minstrmplanlgning.domain.model.ApplianceData
import com.example.minstrmplanlgning.domain.repository.ApplianceRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ApplianceRepositoryImpl(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) : ApplianceRepository {

    override suspend fun addAppliance(appliance: ApplianceData): Result<Unit> {
        return try {
            db.collection("appliances")
                .add(appliance)
                .await() // gør kaldet suspenderbart
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}