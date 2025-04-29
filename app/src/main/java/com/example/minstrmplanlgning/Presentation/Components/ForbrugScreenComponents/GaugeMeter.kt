package com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun GaugeMeter(percentage: Float) {
    Canvas(
        modifier = Modifier
            .size(200.dp)
    ) {
        val sweepAngle = (percentage / 100) * 180f

        // Background arc (red)
        drawArc(
            color = Color.Red,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = 20f)
        )

        // Foreground arc (green)
        drawArc(
            color = Color(0xFF4CAF50), // green color
            startAngle = 180f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 20f)
        )
    }
}

