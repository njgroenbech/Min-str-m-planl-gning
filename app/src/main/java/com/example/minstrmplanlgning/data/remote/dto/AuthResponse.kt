package com.example.minstrmplanlgning.data.remote.dto

data class AuthResponse(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int
)