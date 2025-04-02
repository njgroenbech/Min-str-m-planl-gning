package com.example.minstrmplanlgning.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.minstrmplanlgning.ui.viewmodel.PowerViewModel



@Composable
fun HomeScreen(onScreen2ButtonClick: () -> Unit) {
    val viewModel: PowerViewModel = viewModel()
    val price by viewModel.powerPrice.observeAsState()

    Column {
        Text(
            text = "Screen 1",
            fontSize = 32.sp
        )
        Text(
            text = "Hello!"
        )
        Button(onClick = onScreen2ButtonClick) {
            Text("Go to Screen 2")
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(text = "Strømpris: $price kr/kWh")

        Button(onClick = { viewModel.getPowerPrice() }) {
            Text("Opdater strømpris")
            }
        }
    }


