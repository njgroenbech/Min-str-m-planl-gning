package com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minstrmplanlgning.Presentation.Viewmodel.AuthViewModel
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items


@Composable
fun ProfilScreen() {
    val viewModel = remember { AuthViewModel() }

    val prices by viewModel.prices
    val isLoading by viewModel.isLoading
    val error by viewModel.error
    val token by viewModel.token

    // Only fetch prices when token is available
    LaunchedEffect(token) {
        if (token.isNotBlank()) {
            viewModel.fetchPrices("DK2")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            error.isNotEmpty() -> {
                Text(
                    text = error,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            prices.isNotEmpty() -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(prices) { price ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Date: ${price.date}", style = MaterialTheme.typography.bodyLarge)
                                Text("Price: ${price.price} øre", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }

            else -> {
                Text("No price data yet", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}


