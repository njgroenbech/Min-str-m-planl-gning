package com.example.minstrmplanlgning.Presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarChart() {
    val hours = (0..23).toList()
    val barHeights = List(24) { (50..150).random() } // Fake data
    val maxHeight = 150.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        hours.forEachIndexed { index, hour ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .height(maxHeight + 20.dp)
                    .padding(horizontal = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height((barHeights[index].dp))
                        .background(
                            color = Color(0xFF3B82F6),
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (hour < 10) "0$hour" else "$hour",
                    fontSize = 10.sp
                )
            }
        }
    }
}