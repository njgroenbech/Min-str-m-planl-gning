package com.example.minstrmplanlgning.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FullPriceCopenhagenResponse (

    @SerializedName("date")
    val date: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("charges")
    val charges: Double?,

    @SerializedName("color")
    val color: String?

)