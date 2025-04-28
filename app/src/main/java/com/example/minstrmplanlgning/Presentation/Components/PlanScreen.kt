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
fun PlanScreen() {
    var appliances by remember { mutableStateOf(listOf<Appliance>()) }
    var showAddDeviceSheet by remember { mutableStateOf(false) }
    var selectedApplianceName by remember { mutableStateOf("") }
    var selectedApplianceIconRes by remember { mutableStateOf(0) }
    var showAddDeviceSettingsSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
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
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3B82F6),
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

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(appliances) { appliance ->
                    ApplianceCard(appliance)
                }
            }
        }

        Button(
            onClick = { showAddDeviceSheet = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3B82F6),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp) // Luft over NavigationBar
        ) {
            Text(text = "TILFØJ APPARAT")
        }
    }

    if (showAddDeviceSheet) {
        AddDevice(
            onApplianceSelected = { name, iconRes ->
                selectedApplianceName = name
                selectedApplianceIconRes = iconRes
                showAddDeviceSheet = false
                showAddDeviceSettingsSheet = true
            },
            onDismiss = { showAddDeviceSheet = false }
        )
    }

    if (showAddDeviceSettingsSheet) {
        AddDeviceSettings(
            applianceName = selectedApplianceName,
            onSettingsSaved = { name, duration, time, repeat ->
                val appliance = Appliance(
                    name = name,
                    iconRes = selectedApplianceIconRes,
                    duration = "$duration timer"
                )
                appliances = appliances + appliance
                showAddDeviceSettingsSheet = false
            },
            onDismiss = { showAddDeviceSettingsSheet = false }
        )
    }
}