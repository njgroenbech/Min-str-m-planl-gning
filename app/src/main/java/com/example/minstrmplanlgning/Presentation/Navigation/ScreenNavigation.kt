package com.example.minstrmplanlgning.Presentation.Navigation

import Graphs
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreenComponents.FindSelskabScreen
import com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents.ForbrugScreen
import com.example.minstrmplanlgning.Presentation.Components.PlanScreenComponents.PlanScreen
import com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents.PriserScreen
import com.example.minstrmplanlgning.Presentation.Components.ProfilScreenComponents.ProfilScreen

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
            ForbrugScreen(navController)
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
        composable("Graphs") {
            Graphs(navController)
        }
    }
}
