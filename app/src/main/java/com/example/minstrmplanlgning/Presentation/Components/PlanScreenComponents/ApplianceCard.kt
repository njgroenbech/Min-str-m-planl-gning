package com.example.minstrmplanlgning.Presentation.Components.PlanScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.domain.model.Appliance

// Jacob

@Composable
fun ApplianceCard(
    appliance: Appliance,
    onDelete: (Appliance) -> Unit,
    onEdit: (Appliance) -> Unit
) {
    Card(
        onClick = { onEdit(appliance) },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2FE)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 16.dp, end = 48.dp, top = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = appliance.iconRes),
                    contentDescription = appliance.name,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = appliance.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )
            }

            IconButton(
                onClick = { onDelete(appliance) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Slet appliance",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}