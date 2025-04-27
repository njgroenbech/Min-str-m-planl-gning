package com.example.minstrmplanlgning.Presentation.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlanScreen(onScreen2ButtonClick: () -> Unit = {}) {
    var showChooseDeviceSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
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

                ApplianceCard(
                    applianceName = "Vaskemaskine",
                    time = "14-17"
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

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
                Text(text = "TILFØJ APPARAT")
            }
        }

        // BottomSheet visning
        if (showChooseDeviceSheet) {
            AddDevice(
                onApplianceSelected = { appliance ->
                    showChooseDeviceSheet = false
                    // TODO: Naviger videre baseret på valgt apparat
                },
                onDismiss = { showChooseDeviceSheet = false }
            )
        }
    }
}
