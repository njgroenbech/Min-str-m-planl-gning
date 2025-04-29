package com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun BarChart() {
    val barWidth = 60.dp
    val maxHeight = 200.dp // Maximum height the tallest bar can reach

    val greenBarHeightRatio = 0.7f // 70% of max height
    val redBarHeightRatio = 0.5f   // 50% of max height

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight)
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        // Green bar
        Box(
            modifier = Modifier
                .width(barWidth)
                .fillMaxHeight(greenBarHeightRatio)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRoundRect(
                    color = Color.Green,
                    size = Size(size.width, size.height),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(16f, 16f)
                )
            }
        }

        // Red bar
        Box(
            modifier = Modifier
                .width(barWidth)
                .fillMaxHeight(redBarHeightRatio)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRoundRect(
                    color = Color.Red,
                    size = Size(size.width, size.height),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(16f, 16f)
                )
            }
        }
    }
}

