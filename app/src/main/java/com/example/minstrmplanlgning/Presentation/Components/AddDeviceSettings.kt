package com.example.minstrmplanlgning.Presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceSettings(
    applianceName: String,
    onSettingsSaved: (String, Int, String, String) -> Unit,
    onDismiss: () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var selectedDuration by remember { mutableStateOf(1) }
    var selectedTime by remember { mutableStateOf("Billigste tidspunkt") }
    var selectedRepeat by remember { mutableStateOf("Kun i dag") }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = bottomSheetState,
        containerColor = Color.LightGray,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = applianceName, fontSize = 32.sp)
            Spacer(modifier = Modifier.height(24.dp))

            // Varighed dropdown
            DropdownSelector(
                label = "Varighed:",
                options = (1..24).map { "$it timer" },
                selectedOption = "$selectedDuration timer",
                onOptionSelected = { selected ->
                    selectedDuration = selected.replace(" timer", "").toInt()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tidsrum dropdown
            DropdownSelector(
                label = "Tidsrum:",
                options = listOf("Billigste tidspunkt", "Morgen", "Eftermiddag", "Aften"),
                selectedOption = selectedTime,
                onOptionSelected = { selectedTime = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Gentagelse dropdown
            DropdownSelector(
                label = "Gentagelse:",
                options = listOf("Kun i dag", "Hver dag", "Hver uge"),
                selectedOption = selectedRepeat,
                onOptionSelected = { selectedRepeat = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    onSettingsSaved(applianceName, selectedDuration, selectedTime, selectedRepeat)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3B82F6),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Tilføj")
            }
        }
    }
}
