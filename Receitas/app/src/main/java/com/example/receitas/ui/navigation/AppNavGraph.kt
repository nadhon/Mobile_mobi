package com.example.receitas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.receitas.ui.screen.detail.PostDetailScreen
import com.example.receitas.ui.screen.list.PostListScreen
import com.example.receitas.ui.screen.settings.SettingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            PostListScreen(navController)
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            PostDetailScreen(id)
        }

        composable("settings") {
            SettingsScreen()
        }
    }
}