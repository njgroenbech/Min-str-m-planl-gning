package com.example.minstrmplanlgning.domain.model

// Jacob øverste, nicholas nederste

import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun List<SpotPriceResponse>.toHourlyPrices(): List<HourlyPrice> {
    val formatter = DateTimeFormatter.ISO_DATE_TIME

    return this.mapNotNull { dto ->
        try {
            val time = ZonedDateTime.parse(dto.date, formatter)
            HourlyPrice(
                hour = time.hour,
                price = dto.price,
            )
        } catch (e: Exception) {
            null
        }
    }
}

fun List<FullPriceResponse>.toFullHourlyPrices(): List<HourlyPrice> {
    return this.mapNotNull { fullPrice ->
        val hour = fullPrice.date.substring(11, 13).toIntOrNull() // "YYYY-MM-DDTHH:mm:ss"
        val totalPrice = (fullPrice.price + (fullPrice.charges ?: 0.0)) // keep as DKK
        if (hour != null) {
            HourlyPrice(hour, totalPrice)
        } else {
            null
        }
    }.sortedBy { it.hour }
}

