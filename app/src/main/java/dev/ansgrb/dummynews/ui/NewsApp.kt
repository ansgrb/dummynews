package dev.ansgrb.dummynews.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.ansgrb.dummynews.MockData
import dev.ansgrb.dummynews.ui.screens.DetailsScreen
import dev.ansgrb.dummynews.ui.screens.TopNewsScreen

@Composable
fun NewsApp(paddingValues: PaddingValues) {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    NavHost(navController = navController, startDestination = "TopNewsScreen") {
        composable("TopNewsScreen") {
            TopNewsScreen(navController = navController)
        }
        composable("DetailsScreen/{newsId}",
            arguments = listOf(navArgument("newsId") {type = NavType.IntType})
        ) {
            navBackStackEntry ->
            val newsId = navBackStackEntry.arguments?.getInt("newsId")
            val newsData = MockData.getNewsById(newsId)
            if (newsData != null) {
                DetailsScreen(navController = navController, newsData = newsData, scrollState)
            }
        }

    }

}