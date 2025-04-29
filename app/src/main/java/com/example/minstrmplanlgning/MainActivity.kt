package com.example.minstrmplanlgning

import NavigationBar
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.minstrmplanlgning.Presentation.Navigation.ScreenNavigation

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { NavigationBar(navController) }
            ) {
                ScreenNavigation(navController)
            }

            fun main() {
                // Log the key to Logcat
                Log.d("API_KEY", BuildConfig.API_KEY ?: "API_KEY is null")
                Log.d("SECRET_KEY", BuildConfig.SECRET_KEY ?: "API_SECRET is null")

            }

            main()
        }
    }
}
