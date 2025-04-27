package com.example.minstrmplanlgning.Presentation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.R

@Composable
fun HomeScreen(onScreen2ButtonClick: () -> Unit = {}) {
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
                    .padding(bottom = 16.dp)
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

@Composable
fun ApplianceCard(applianceName: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_2),
                contentDescription = "Appliance Icon",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = applianceName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = time,
                fontSize = 18.sp
            )
        }
    }
}

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
