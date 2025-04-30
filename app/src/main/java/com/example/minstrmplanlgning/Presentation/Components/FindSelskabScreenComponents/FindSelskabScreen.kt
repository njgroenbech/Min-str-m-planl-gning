package com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreenComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minstrmplanlgning.Presentation.Viewmodel.AuthViewModel
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FindSelskabScreen() {
    // Use the viewModel() function to retrieve the ViewModel properly
    val viewModel: AuthViewModel = viewModel()

    val fullPrices by viewModel.fullPrices
    val isLoading by viewModel.isLoading
    val error by viewModel.error
    val token by viewModel.token

    // Fetch full prices when token is ready
    LaunchedEffect(token) {
        if (token.isNotBlank()) {
            viewModel.getFullPricesCopenhagen()
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

            fullPrices.isNotEmpty() -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(
                            text = "Electricity Prices incl. Charges",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    items(fullPrices) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Date: ${item.date}", style = MaterialTheme.typography.bodyLarge)
                                Text("Total Price: ${item.price} øre", style = MaterialTheme.typography.bodyMedium)
                                item.charges?.let {
                                    Text("Charges: $it øre", style = MaterialTheme.typography.bodySmall)
                                Text("Color: ${item.color}", style = MaterialTheme.typography.bodySmall)
                                }
                            }
                        }
                    }
                }
            }

            else -> {
                Text("No full price data yet", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

