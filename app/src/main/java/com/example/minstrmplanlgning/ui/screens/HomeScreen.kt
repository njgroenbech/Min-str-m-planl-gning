package com.example.minstrmplanlgning.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.minstrmplanlgning.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    onScreen2ButtonClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val isClicked by viewModel.isClicked.collectAsState()

    val backgroundColor = if (isClicked) Color(0xFFB3E5FC) else Color(0xFFE1F5FE)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Tryk på knappen for at ændre baggrund", style = MaterialTheme.typography.bodyLarge)
            Button(onClick = { viewModel.toggleBackground() }) {
                Text("Skift baggrundsfarve")
            }
            Button(onClick = onScreen2ButtonClick) {
                Text("Gå til Screen 2")
            }
        }
    }
}
