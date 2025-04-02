package com.example.minstrmplanlgning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minstrmplanlgning.ui.screens.HomeScreen
import com.example.minstrmplanlgning.ui.screens.Screen2

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onScreen2ButtonClick = {
                    navController.navigate(Routes.SCREEN2)
                }
            )
        }
        composable(Routes.SCREEN2) {
            Screen2(
                onBackButtonClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
