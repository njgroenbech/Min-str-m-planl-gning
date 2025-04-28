package com.example.minstrmplanlgning.Presentation.Navigation

import ForbrugScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreen
import com.example.minstrmplanlgning.Presentation.Components.PlanScreen
import com.example.minstrmplanlgning.Presentation.Components.PriserScreen
import com.example.minstrmplanlgning.Presentation.Components.ProfilScreen

@Composable
fun ScreenNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Planlæg"
    ) {
        composable("Planlæg") {
            PlanScreen()
        }
        composable("Forbrug") {
            ForbrugScreen()
        }
        composable("Find Selskab") {
            FindSelskabScreen()
        }
        composable("Priser") {
            PriserScreen()
        }
        composable("Profil") {
            ProfilScreen()
        }
    }
}
