package com.example.minstrmplanlgning.domain.model

// Jacob

fun Appliance.toApplianceData(): ApplianceData {
    return ApplianceData(
        name = this.name,
        duration = this.duration?.replace(" timer", "")?.toIntOrNull() ?: 0,
        startTime = System.currentTimeMillis()
    )
}