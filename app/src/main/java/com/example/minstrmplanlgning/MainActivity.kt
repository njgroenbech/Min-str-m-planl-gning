package com.example.minstrmplanlgning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minstrmplanlgning.Presentation.Navigation.NavigateHomeAndScreen2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column {
                Spacer(
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(
                    text = "Example of navigation between 2 screens",
                    fontSize = 20.sp
                )
                NavigateHomeAndScreen2()
            }
        }
    }
}