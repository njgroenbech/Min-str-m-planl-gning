package com.example.minstrmplanlgning.Presentation.Components.PlanScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.domain.model.HourlyPrice
import kotlin.math.roundToInt

@Composable
fun BarChart(hourlyPrices: List<HourlyPrice>) {
    val maxPrice = hourlyPrices.maxOfOrNull { it.price } ?: 1.0
    val minPrice = hourlyPrices.minOfOrNull { it.price } ?: 0.0
    val maxHeight = 200.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        hourlyPrices.forEach { price ->
            val heightFraction = (price.price - minPrice) / (maxPrice - minPrice).coerceAtLeast(0.01)
            val barHeight = maxHeight * heightFraction.toFloat()
            val barColor = getPriceColor(heightFraction)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .height(maxHeight + 40.dp)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "${price.price.roundToInt()} øre",
                    fontSize = 9.sp
                )

                Box(
                    modifier = Modifier
                        .width(8.dp) // smallere søjle
                        .height(barHeight)
                        .background(
                            color = barColor,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                        )
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = String.format("%02d", price.hour),
                    fontSize = 9.sp
                )
            }
        }
    }
}

fun getPriceColor(fraction: Double): Color {
    return when {
        fraction < 0.33 -> Color(0xFF10B981) // grøn
        fraction < 0.66 -> Color(0xFFF59E0B) // gul
        else -> Color(0xFFEF4444)           // rød
    }
}