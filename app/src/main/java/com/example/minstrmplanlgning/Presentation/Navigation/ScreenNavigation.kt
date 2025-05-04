package com.example.minstrmplanlgning.Presentation.Navigation

import GraphsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreenComponents.FindSelskabScreen
import com.example.minstrmplanlgning.Presentation.Components.FindSelskabScreenComponents.PriserScreen
import com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents.ForbrugScreen
import com.example.minstrmplanlgning.Presentation.Components.PlanScreenComponents.PlanScreen
import com.example.minstrmplanlgning.Presentation.Components.PriserScreenComponents.ProfilScreen


// Nicholas har arbejdet på navigation

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
            GraphsScreen(navController)
        }
    }
}
