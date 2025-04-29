package com.example.minstrmplanlgning.domain.model

data class SpotPrice(
    val date: String,
    val price: Double,
    val color: String? = null
)
