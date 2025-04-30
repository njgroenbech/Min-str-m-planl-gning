package com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreenComponents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents.PriserScreenBarChart
import com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents.PriserScreenCardForChart
import com.example.minstrmplanlgning.Presentation.Viewmodel.AuthViewModel
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun PriserScreen() {
    val viewModel: AuthViewModel = viewModel()

    val fullPrices by viewModel.fullPrices
    val token by viewModel.token
    val isLoading by viewModel.isLoading
    val error by viewModel.error

    // trigger data fetch
    LaunchedEffect(token) {
        if (token.isNotBlank()) {
            viewModel.getFullPricesCopenhagen()
        }
    }

    when {
        isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        error.isNotEmpty() -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $error", color = MaterialTheme.colorScheme.error)
            }
        }

        fullPrices.isNotEmpty() -> {
            val formatter = DateTimeFormatter.ISO_DATE_TIME

            val labels = fullPrices.mapNotNull { item ->
                try {
                    val dateTime = ZonedDateTime.parse(item.date, formatter)
                    dateTime.withZoneSameInstant(ZoneId.of("Europe/Copenhagen")).hour.toString().padStart(2, '0')
                } catch (e: Exception) {
                    null
                }
            }

            val values = fullPrices.map { (it.price + (it.charges ?: 0.0)).toFloat() }

            // 🧱 Add spacing and padding to avoid being hidden
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 36.dp, bottom = 76.dp) // adjust bottom padding as needed
            ) {
                PriserScreenCardForChart(labels = labels, values = values)
            }
        }

        else -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Waiting for data...")
            }
        }
    }
}




