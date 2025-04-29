package com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TilbageTilForbrugCard(onClickNavigation: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier
            .wrapContentHeight()
            .clickable { // Card is clickable
                onClickNavigation()
            }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Tilbage",
                tint = Color.Black
            )
        }
    }
}