package com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Nicholas

@Composable
fun PriserScreenBarChart(
    labels: List<String>,
    values: List<Float>,
    maxValue: Float = values.maxOrNull() ?: 1f
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        itemsIndexed(values) { index, value ->
            val label = labels.getOrNull(index) ?: ""

            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                Text(
                    text = "$label:00",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .background(Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(12.dp))
                ) {
                    val barFraction = value / maxValue

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(barFraction)
                            .background(Color(0xFF3B82F6), shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "${"%.2f".format(value)} Kr.",
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
