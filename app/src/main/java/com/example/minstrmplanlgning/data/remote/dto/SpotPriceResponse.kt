package com.example.minstrmplanlgning.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SpotPriceResponse (

    @SerializedName("date")
    val date: String,

    @SerializedName("price")
    val price: Double,

)