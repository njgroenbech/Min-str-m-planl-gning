package com.example.minstrmplanlgning.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PriceResponseDK2 (

    @SerializedName("date")
    val date: String,

    @SerializedName("price")
    val price: Double,

)