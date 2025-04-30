package com.example.minstrmplanlgning.data.mapper

import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import com.example.minstrmplanlgning.domain.model.HourlyPrice
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun List<PriceResponseDK2>.toHourlyPrices(): List<HourlyPrice> {
    val formatter = DateTimeFormatter.ISO_DATE_TIME

    return this.mapNotNull { dto ->
        try {
            val time = ZonedDateTime.parse(dto.date, formatter)
            HourlyPrice(
                hour = time.hour,
                price = dto.price
            )
        } catch (e: Exception) {
            null
        }
    }
}