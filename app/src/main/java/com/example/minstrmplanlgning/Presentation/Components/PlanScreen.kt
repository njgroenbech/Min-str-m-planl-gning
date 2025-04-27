package com.example.minstrmplanlgning.Presentation.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.domain.model.Appliance

@Composable
fun PlanScreen(onScreen2ButtonClick: () -> Unit = {}) {
    var showChooseDeviceSheet by remember { mutableStateOf(false) }
    var appliances by remember { mutableStateOf(listOf<Appliance>()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f) // This makes sure that the list takes all the remaining space
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Plan",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(
                        text = "I dag",
                        fontSize = 32.sp,
                        color = Color(0xFF3B82F6),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 32.dp, end = 98.dp)
                    )
                    Text(
                        text = "Kalender",
                        fontSize = 32.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                BarChart()

                Spacer(modifier = Modifier.height(24.dp))

                // lazycolumn to be able to scroll through the appliance list
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(appliances) { appliance ->
                        ApplianceCard(appliance)
                    }
                }
            }

            // add device button
            Button(
                onClick = { showChooseDeviceSheet = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3B82F6),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 76.dp)
            ) {
                Text(text = "TILFØJ ENHED")
            }
        }

        //bottomSheet for adding devices
        if (showChooseDeviceSheet) {
            AddDevice(
                onApplianceSelected = { appliance ->
                    appliances = appliances + appliance //add selected appliance to the list
                    showChooseDeviceSheet = false
                },
                onDismiss = { showChooseDeviceSheet = false }
            )
        }
    }
}
