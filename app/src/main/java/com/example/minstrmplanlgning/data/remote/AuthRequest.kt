package com.example.minstrmplanlgning.data.remote

import com.google.gson.annotations.SerializedName

data class AuthRequest(

    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("client_secret")
    val clientSecret: String
)