package com.example.minstrmplanlgning.Presentation.Components.PlanScreenComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.R

// Jacob

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDevice(
    onApplianceSelected: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = bottomSheetState,
        containerColor = Color.LightGray,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Vælg enhed", fontSize = 28.sp)
            Spacer(modifier = Modifier.height(24.dp))

            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ApplianceButton(
                        name = "Vaskemaskine",
                        iconRes = R.drawable.image_2,
                        onClick = { onApplianceSelected("Vaskemaskine", R.drawable.image_2) }
                    )
                    ApplianceButton(
                        name = "Elbil",
                        iconRes = R.drawable.image_4,
                        onClick = { onApplianceSelected("Elbil", R.drawable.image_4) }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ApplianceButton(
                        name = "Ovn",
                        iconRes = R.drawable.image_3,
                        onClick = { onApplianceSelected("Ovn", R.drawable.image_3) }
                    )
                    ApplianceButton(
                        name = "Mikroovn",
                        iconRes = R.drawable.image_1,
                        onClick = { onApplianceSelected("Mikroovn", R.drawable.image_1) }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ApplianceButton(
                        name = "Opvaskemaskine",
                        iconRes = R.drawable.image_5,
                        onClick = { onApplianceSelected("Opvaskemaskine", R.drawable.image_5) }
                    )
                    ApplianceButton(
                        name = "Andet",
                        iconRes = R.drawable.image_6,
                        onClick = { onApplianceSelected("Andet", R.drawable.image_6) }
                    )
                }
            }
        }
    }
}

