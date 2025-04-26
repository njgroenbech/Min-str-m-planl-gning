package com.example.minstrmplanlgning.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minstrmplanlgning.Presentation.Components.HomeScreen
import com.example.minstrmplanlgning.Presentation.Components.Screen2

@Composable
fun NavigateHomeAndScreen2 () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home-screen") {
        composable("home-screen") {
            HomeScreen(onScreen2ButtonClick = {
                    navController.navigate("screen-2")
                })
        }
        composable("screen-2") {
            Screen2(onBackButtonClick = {
                // This will go back to the home-screen
                navController.popBackStack()
            })
        }
    }
}