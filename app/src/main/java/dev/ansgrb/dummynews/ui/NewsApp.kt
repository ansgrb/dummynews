package dev.ansgrb.dummynews.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ansgrb.dummynews.ui.screens.DetailsScreen
import dev.ansgrb.dummynews.ui.screens.TopNewsScreen

@Composable
fun NewsApp(paddingValues: PaddingValues) {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "TopNewsScreen") {
        composable("TopNewsScreen") {
            TopNewsScreen(navController = navController)
        }
        composable("DetailsScreen") {
            DetailsScreen(navController = navController)
        }

    }

}